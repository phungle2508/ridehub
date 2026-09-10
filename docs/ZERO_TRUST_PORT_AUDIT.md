# BÁO CÁO KIỂM TOÁN CỔNG MẠNG & TIÊU CHÍ ZERO TRUST TRÊN VPS RIDEHUB

> **Ngày thực hiện**: 10/09/2026  
> **Mục tiêu**: Đánh giá toàn bộ cổng mạng (Host OS, Docker daemon, Cloud Firewall) theo nguyên tắc **Zero Trust (Không tin cậy bất kỳ kết nối Inbound trực tiếp nào)** và ghi nhận các rủi ro bảo mật cần xử lý sau.  
> **IP Public VPS**: `136.85.105.222` (GCP Compute Engine: `instance-20260906-055426`)  
> **Mạng ảo WARP Private Network**: `172.18.0.0/16` (Infra) & `172.19.0.0/16` (Microservices)

---

## 1. Bảng Tổng Hợp Kiểm Toán Cổng Mạng (Port Audit Matrix)

| Cổng (Port) | Dịch vụ | Trạng thái Bind trên Host | Kết quả quét từ Public IP | Đánh giá Zero Trust | Mức độ rủi ro |
| :--- | :--- | :--- | :---: | :---: | :---: |
| **22/tcp** | OpenSSH Server | `0.0.0.0:22` (Tất cả Card mạng) | 🔴 **OPEN** | ❌ **Vi phạm** | 🔴 **CAO** |
| **80, 443/tcp** | Nginx Ingress | `127.0.0.1:80` (Localhost) | 🟢 **CLOSED** | ✅ **Đạt** | 🟢 Không |
| **8088/tcp** | MS Nginx Ingress | `127.0.0.1:8088` (Localhost) | 🟢 **CLOSED** | ✅ **Đạt** | 🟢 Không |
| **3307 - 3310** | 4 MySQL Services | `127.0.0.1:3307 - 3310` | 🟢 **CLOSED** | ✅ **Đạt** | 🟢 Không |
| **Keycloak, Vault, Reposilite, Kafka-UI** | Internal Infra Apps | Không publish cổng Host | 🟢 **CLOSED** | ✅ **Đạt** | 🟢 Không |
| **6379/tcp** | Redis Cache/Queue | `0.0.0.0:6379` (Docker proxy) | 🟡 **BLOCKED (GCP)** | ⚠️ **Chưa hoàn thiện** | 🟡 **TRUNG BÌNH** |
| **8500/tcp** | HashiCorp Consul UI/API | `0.0.0.0:8500` (Docker proxy) | 🟡 **BLOCKED (GCP)** | ⚠️ **Chưa hoàn thiện** | 🟡 **TRUNG BÌNH** |
| **9093/tcp** | Kafka Broker (SSL) | `0.0.0.0:9093` (Docker proxy) | 🟡 **BLOCKED (GCP)** | ⚠️ **Chưa hoàn thiện** | 🟡 **TRUNG BÌNH** |
| **9094/tcp** | Kafka Broker (Plaintext) | `0.0.0.0:9094` (Docker proxy) | 🟡 **BLOCKED (GCP)** | ⚠️ **Chưa hoàn thiện** | 🔴 **CAO (Plain)** |
| **9090/tcp** | Prometheus Metrics | `0.0.0.0:9090` (Docker proxy) | 🟡 **BLOCKED (GCP)** | ⚠️ **Chưa hoàn thiện** | 🟡 **TRUNG BÌNH** |
| **9200/tcp** | Elasticsearch Cluster | `0.0.0.0:9200` (Docker proxy) | 🟡 **BLOCKED (GCP)** | ⚠️ **Chưa hoàn thiện** | 🟡 **TRUNG BÌNH** |
| **3000, 3100** | Grafana, Loki | `0.0.0.0:3000, 3100` (Docker proxy) | 🟡 **BLOCKED (GCP)** | ⚠️ **Chưa hoàn thiện** | 🟡 **TRUNG BÌNH** |
| **1080/tcp** | SOCKS5 Proxy | `0.0.0.0:1080` (Docker proxy) | 🟡 **BLOCKED (GCP)** | ⚠️ **Chưa hoàn thiện** | 🟡 **TRUNG BÌNH** |
| **8080/tcp** | Spring Cloud Gateway | `0.0.0.0:8080` (Docker proxy) | 🟡 **BLOCKED (GCP)** | ⚠️ **Chưa hoàn thiện** | 🟡 **TRUNG BÌNH** |
| **8082 - 8085** | MS Route, User, Booking, Promo | `0.0.0.0:808x` (Docker proxy) | 🟡 **BLOCKED (GCP)** | ⚠️ **Chưa hoàn thiện** | 🟡 **TRUNG BÌNH** |

---

## 2. Phân Tích Hiện Trạng & Đánh Giá Rủi Ro

### A. Những điểm đã ĐẠT chuẩn Zero Trust
1. **Lớp Web Ingress (Layer 7)**:
   - Toàn bộ lưu lượng HTTP/HTTPS công khai (`*.phungvip.io.vn`) không nhận kết nối Inbound trực tiếp từ bên ngoài.
   - 100% traffic đi qua **Cloudflare Edge (WAF, DDOS Protection, SSL)** và đổ về server qua kết nối Outbound duy nhất của daemon **Cloudflare Tunnel (`cloudflared`)**.
2. **Cơ sở dữ liệu (MySQL Database)**:
   - Các cổng MySQL được cô lập nghiêm ngặt: chỉ bind vào `127.0.0.1` của Host hoặc giao tiếp nội bộ container network. Không có nguy cơ bị tấn công từ xa.
3. **Các ứng dụng lõi (Keycloak, Vault, Reposilite, Kafka-UI)**:
   - Hoàn toàn không mở cổng ra Host OS. Tất cả truy cập của quản trị viên đều phải xác thực danh tính qua Cloudflare Access OIDC.

---

### B. Những điểm CHƯA ĐẠT và CẦN GIẢI QUYẾT

### 🔴 Rủi ro 1: Cổng SSH (22) mở trực tiếp ra toàn cầu (`0.0.0.0:22`)
- **Vấn đề**: Khi quét trực tiếp vào IP Public `136.85.105.222:22`, kết nối TCP thành công ngay lập tức (**OPEN**).
- **Hệ quả**:
  - Hacker có thể quét dải IP GCP và chạy bot dò quét / brute-force mật khẩu hoặc khai thác lỗ hổng OpenSSH (như CVE regreSSHion).
  - Bỏ qua toàn bộ cơ chế bảo vệ **Cloudflare Access OIDC / Keycloak Admin-Only Policy** mà chúng ta đã cấu hình cho domain `ssh.phungvip.io.vn`.
- **Mục tiêu Zero Trust**: Cổng 22 trên Host **phải bị đóng hoàn toàn với Internet công cộng**. Quản trị viên chỉ được phép SSH thông qua Cloudflare Tunnel (`ssh.phungvip.io.vn`) hoặc qua Cloudflare WARP.

---

### 🟡 Rủi ro 2: Docker Daemon tự động mở các cổng nội bộ ra `0.0.0.0` (Vi phạm Defense-in-Depth)
- **Vấn đề**:
  - Trong các file `docker-compose.yml`, nhiều service vẫn dùng cú pháp mở cổng công cộng:
    - Kafka: `ports: - "9093:9093"`, `ports: - "9094:9092"`
    - Redis: `ports: - "6379:6379"`
    - Consul: `ports: - "8500:8500"`
    - Prometheus: `ports: - "9090:9090"`
    - Elasticsearch: `ports: - "9200:9200"`
    - Microservices: `ports: - "8080:8080"`, `"8082:8082"`, v.v.
  - Khi dùng `ports: - "xxxx:xxxx"`, Docker tự động chèn rule vào `iptables` (bảng `nat` và `filter`) để lắng nghe trên `0.0.0.0` của mọi interface mạng vật lý.
- **Tại sao hiện tại chưa bị lộ?**:
  - Do **GCP VPC Firewall** mặc định chặn Inbound ngoài port 22.
- **Nguy cơ tiềm ẩn**:
  - Vi phạm nguyên tắc **Defense-in-Depth** (Phòng thủ đa tầng). Nếu ai đó vô tình tạo rule mở cổng trên GCP Firewall, hoặc khi chuyển dịch hệ thống sang nhà cung cấp VPS không có Cloud Firewall ngoại vi (như Hetzner, OVH, Linode, bare-metal), **toàn bộ dữ liệu Redis, Kafka, Consul sẽ phơi bày không có lớp chắn**.
- **Cơ sở để gỡ bỏ hoàn toàn**:
  - Chúng ta đã triển khai thành công **Cloudflare WARP Private Network** trỏ trực tiếp vào Subnet `172.18.0.0/16` (Infra) và `172.19.0.0/16` (Microservices).
  - Lập trình viên bật WARP có thể kết nối thẳng vào IP container (ví dụ `172.18.0.16:6379`) một cách an toàn mà **không cần Docker phải publish bất kỳ cổng nào ra Host**.

---

## 3. Lộ Trình & Hướng Dẫn Khắc Phục (Khi bạn sẵn sàng xử lý)

### Bước 1: Khóa cổng SSH 22 trên GCP Firewall và Host OS
1. **Trên GCP Console (VPC Network -> Firewall)**:
   - Sửa rule `default-allow-ssh`:
     - Tắt hoặc giới hạn Source IP (chỉ cho phép IP nhà/công ty cố định nếu có).
     - Hoặc xóa bỏ hoàn toàn rule này để chặn toàn bộ Inbound SSH từ Internet công cộng.
2. **Khóa cổng SSH bằng `iptables` trên VPS (chỉ cho phép Cloudflare Tunnel & WARP)**:
   ```bash
   # Chỉ cho phép SSH từ localhost (nơi cloudflared forward vào) và dải WARP container:
   sudo iptables -A INPUT -p tcp --dport 22 -s 127.0.0.1 -j ACCEPT
   sudo iptables -A INPUT -p tcp --dport 22 -s 172.18.0.0/16 -j ACCEPT
   sudo iptables -A INPUT -p tcp --dport 22 -s 172.19.0.0/16 -j ACCEPT
   sudo iptables -A INPUT -p tcp --dport 22 -j DROP
   ```

---

### Bước 2: Dọn dẹp các cổng thừa trong `docker-compose.yml`

#### 1. Tại `infra/vps-infra/docker-compose.yml`:
Chuyển các service nội bộ sang chế độ không mở cổng Host (hoặc chỉ bind `127.0.0.1` nếu cực kỳ cần thiết):
- **Kafka**:
  ```yaml
  # Xóa hoặc comment lại các cổng mở 0.0.0.0:
  # ports:
  #   - "9094:9092"
  #   - "9093:9093"
  expose:
    - "9092"
    - "9093"
  ```
  *(Các service khác truy cập qua tên `kafka:9092` hoặc WARP client qua `172.18.0.7:9093`)*.

- **Redis**:
  ```yaml
  # Thay vì ports: - "6379:6379"
  expose:
    - "6379"
  ```

- **Consul, Prometheus, Elasticsearch, Loki, Grafana**:
  Chuyển từ `ports` sang `expose` hoặc chỉ bind `127.0.0.1:xxxx` nếu cần reverse proxy Nginx trên host gọi vào. Quản trị viên truy cập UI thông qua Nginx + Cloudflare Access (`consul.phungvip.io.vn`, `grafana.phungvip.io.vn`).

#### 2. Tại `infra/vps-microservices/docker-compose.yml`:
- Các microservices (`ms_user`, `ms_trip`, `ms_booking`, `ms_payment`, `gateway`):
  Xóa bỏ ánh xạ cổng ra host (`8080`, `8082 - 8085`). Mọi request từ bên ngoài vào microservices đều phải đi qua **`ms-nginx`** (được bảo vệ bởi Cloudflare Tunnel).

---

## 4. Trạng Thái Mong Đợi Sau Khi Khắc Phục

```
[Internet Công Cộng]
        │
        ├──❌ Gặp IP VPS (136.85.105.222:*) ──> DROP / TIMEOUT 100% (Không 1 cổng nào mở)
        │
        └──✅ Truy cập Domain (*.phungvip.io.vn)
                │
                ▼
        [Cloudflare Edge / Zero Trust WAF]
                │
                ├── Xác thực OIDC Keycloak (Admin / Dev)
                │
                ▼ (Outbound WireGuard / HTTP2 Tunnel)
        [Cloudflared Daemon bên trong VPS]
                │
                ▼
        [Docker Private Networks: 172.18.0.0/16 & 172.19.0.0/16]
```
- Không có bất kỳ Inbound Port nào lắng nghe trực tiếp trên IP Public của VPS.
- Hệ thống đạt **Chuẩn Zero Trust Tuyệt Đối (Zero Inbound Ports Exposed)**.
