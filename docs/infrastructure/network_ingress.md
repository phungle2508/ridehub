# HẠ TẦNG: NETWORK & INGRESS (CLOUDFLARE TUNNEL, NGINX & WIREGUARD MESH)

> **Phạm vi quản lý**: Cổng định tuyến lưu lượng vào (Ingress Routing), Bảo mật mạng biên Zero Trust (Cloudflare Tunnel), Cân bằng tải & Reverse Proxy (Nginx), và Mạng riêng ảo kết nối an toàn đa máy chủ (WireGuard Mesh VPN Layer 4).

---

## 1. Bản chất & Cơ chế Mạng Hai Lớp (Dual-Layer Network)

RideHub áp dụng mô hình mạng đa máy chủ (Multi-VPS First) tiên tiến, chia thành 2 lớp bảo mật riêng biệt:

```
[INTERNET] ──► (Cloudflare Edge / WAF) ──► (QUIC Tunnel) ──► [Nginx Layer 7] ──► [Web/API Gateway]
                                                                                      │
                                      ┌───────────────────────────────────────────────┘
                                      ▼
[VPS 1] ◄════ (Mạng riêng ảo WireGuard Mesh VPN - Layer 4: Kafka, Redis, MySQL) ════► [VPS 2]
```

* **Lớp Layer 7 (HTTP / HTTPS)**: Toàn bộ lưu lượng web và API công khai đi qua Cloudflare Tunnel. Không cần mở bất kỳ cổng 80/443 nào trên Firewall VPS. Cloudflare bảo vệ chống tấn công DDoS, tự động cấp chứng chỉ SSL và quản lý xác thực Zero Trust.
* **Lớp Layer 4 (TCP Private Mesh)**: Các kết nối nội bộ giữa các microservices và hạ tầng (Kafka 9093, Redis 6379, MySQL 3306, Consul Gossip 8301) chạy hoàn toàn trong đường hầm mã hóa **WireGuard Mesh VPN** giữa các VPS.
* **Bức tường lửa UFW (Zero Open Ports)**: VPS chặn toàn bộ cổng vào từ Internet công cộng (ngoại trừ cổng UDP của WireGuard), loại bỏ 100% nguy cơ bị rà quét cổng (Port Scanning).

---

## 2. Hiện trạng đã triển khai trong Repo RideHub (As-Is)

Mạng và Ingress được cấu hình tại `infra/vps-infra/` và hướng dẫn tại `docs/guides/WIREGUARD_UFW_GUIDE.md`:

1. **Cloudflare Tunnel (`central-server-config/cloudflared/`)**:
   * Template `config.yml.template` tự động sinh các ingress rules trỏ domain con về Nginx:
     * `vault.phungvip.io.vn` $\rightarrow$ Nginx $\rightarrow$ `vault:8200`
     * `consul.phungvip.io.vn` $\rightarrow$ Nginx $\rightarrow$ `consul:8500`
     * `keycloak.phungvip.io.vn` $\rightarrow$ Nginx $\rightarrow$ `keycloak:8080`
2. **Nginx Reverse Proxy (`central-server-config/nginx/`)**:
   * Phân luồng các subdomain về đúng container trên mạng bridge `ridehub-network`.
   * Cấu hình WebSocket proxy cho Grafana và Keycloak.
3. **WireGuard VPN Setup Script**:
   * Tài liệu `docs/guides/WIREGUARD_UFW_GUIDE.md` quy định dải IP Mesh `10.8.0.0/24` để kết nối liên VPS.

---

## 3. Những hạn chế & Tiềm năng chưa khai thác

| Tiềm năng chưa khai thác | Hiện trạng thực tế tại RideHub | Rủi ro / Điểm nghẽn |
|---|---|---|
| **Loại bỏ giả định `host-gateway`** | File compose hiện tại vẫn dùng `extra_hosts: kafka...:host-gateway` (giả định chạy chung 1 máy). | Khi tách service sang VPS thứ 2, cấu hình này sẽ lập tức báo lỗi không tìm thấy host. |
| **Nginx Static Asset Caching & Compression** | Nginx chưa bật nén Brotli / Gzip cho các file Javascript/CSS của Web Angular Gateway. | Tốc độ tải trang lần đầu của khách hàng chậm hơn, tiêu tốn nhiều băng thông VPS. |
| **Cloudflare WAF Custom Rate Limits** | Đang dùng chính sách WAF mặc định của Cloudflare. | Chưa có quy tắc chặn riêng các IP cào dữ liệu lịch trình xe hoặc chặn request bất thường vào endpoint thanh toán. |
| **Tự động hóa cấu hình WireGuard (Mesh Auto-Discovery)** | Đang cấu hình file `wg0.conf` thủ công bằng tay khi thêm VPS mới. | Mất thời gian và dễ cấu hình sai IP khi mở rộng lên cụm 5 - 10 VPS. |

---

## 4. Bảng kế hoạch lộ trình (Network Roadmap)

| Giai đoạn | Tính năng | Mục tiêu | Độ ưu tiên | Vị trí can thiệp |
|:---:|---|---|:---:|---|
| **P1** | **Gỡ bỏ `host-gateway` sang IP WireGuard** | Thay thế toàn bộ địa chỉ `host-gateway` bằng IP mạng Mesh WireGuard (`10.8.0.x`) để sẵn sàng cho N-VPS. | **P0 (Cần làm ngay)** | • `vps-infra/docker-compose.yml`<br>• `generate-configs.sh` |
| **P2** | **Bật Nén Brotli/Gzip & Cache Nginx** | Tăng tốc độ load trang web Angular lên 300%, giảm tải CPU cho Gateway. | **P1 (Tối ưu tốc độ)** | • `central-server-config/nginx/nginx.conf` |
| **P3** | **Cloudflare WAF Custom Rules (Chống Bot)** | Thiết lập luật WAF tại Cloudflare Edge: Chặn truy cập từ các quốc gia ngoài Việt Nam vào trang thanh toán vé; chặn bot scan. | **P1 (Bảo mật biên)** | • Cloudflare Dashboard |
| **P4** | **Chuyển dịch sang Tailscale / Netbird Mesh** | Nâng cấp từ WireGuard thủ công lên mạng Mesh tự động nhận diện IP (Auto NAT-Traversal) không cần cấu hình file tĩnh. | **P2 (Vận hành tự động)** | • Hạ tầng Multi-VPS |
| **P5** | **Zero-Downtime Blue-Green Deployment** | Cấu hình Nginx reload upstream động khi deploy phiên bản mới của Microservice mà không rớt request nào. | **P2 (Độ tin cậy)** | • Nginx configuration |

---

## 5. Chi tiết kỹ thuật & Hướng dẫn triển khai

### A. Chuẩn hóa chuyển dịch `host-gateway` sang IP Wireguard Mesh
Trong `docker-compose.yml` của các microservice ở VPS phụ:

```yaml
# KHÔNG DÙNG CÁCH CŨ (Chỉ chạy được trên cùng 1 VPS):
# extra_hosts:
#   - "kafka.phungvip.io.vn:host-gateway"

# THAY BẰNG CÁCH CHUẨN MULTI-VPS (Chạy được ở mọi VPS trên thế giới):
services:
  ms_booking:
    environment:
      # Trỏ thẳng tới IP Wireguard của VPS Hạ tầng Trung tâm
      - KAFKA_BROKERS=10.8.0.1:9093
      - SPRING_CLOUD_CONSUL_HOST=10.8.0.1
      - SPRING_CLOUD_VAULT_URI=http://10.8.0.1:8200
```

### B. Tối ưu hóa Nginx Reverse Proxy (`nginx.conf`)
Cấu hình nén gzip và buffer tối ưu cho Angular Frontend:

```nginx
http {
    # Bật nén Gzip giảm kích thước file truyền tải
    gzip on;
    gzip_vary on;
    gzip_proxied any;
    gzip_comp_level 6;
    gzip_types text/plain text/css application/json application/javascript text/xml application/xml application/xml+rss text/javascript image/svg+xml;

    # Tối ưu Buffer tránh ghi file tạm vào ổ đĩa khi tải file lớn
    client_body_buffer_size 128k;
    client_max_body_size 20M;
    proxy_buffer_size 128k;
    proxy_buffers 4 256k;
    proxy_busy_buffers_size 256k;

    # Bảo vệ ẩn thông tin server
    server_tokens off;
}
```

