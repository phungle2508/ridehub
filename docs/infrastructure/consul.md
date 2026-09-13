# HẠ TẦNG: HASHICORP CONSUL (SERVICE DISCOVERY & DYNAMIC CONFIG)

> **Phạm vi quản lý**: Định tuyến & Khám phá dịch vụ (Service Discovery), Kiểm tra sức khỏe (Health Checking), Cấu hình động tải nóng (Consul KV & Dynamic Reload), và Phân quyền hạ tầng (Consul ACL).

---

## 1. Bản chất & Cơ chế hoạt động của Consul

HashiCorp Consul là xương sống kết nối mạng trong kiến trúc microservices phân tán (Multi-VPS):
* **Service Discovery**: Mỗi microservice khi khởi động sẽ tự động đăng ký tên, IP/FQDN và cổng của nó vào Consul Catalog. Các service khác (hoặc API Gateway) chỉ cần gọi tên service (vd: `lb://ms_user`), Consul sẽ tự động cân bằng tải.
* **Continuous Health Checks**: Consul định kỳ gửi HTTP request đến `/management/health` của từng service. Nếu một service chết, Consul tự động loại bỏ nó khỏi bảng định tuyến trong vòng vài giây.
* **Key-Value (KV) Store with Watchers**: Lưu trữ cấu hình ứng dụng. Khi một key thay đổi trên Consul, Consul có thể gửi thông báo tín hiệu (watch/event) giúp Spring Boot reload cấu hình nóng ngay lập tức.
* **Multi-Datacenter / Multi-VPS**: Hỗ trợ mở rộng cụm (Federation / WAN Gossip) giữa các VPS ở nhiều quốc gia khác nhau.

---

## 2. Hiện trạng đã triển khai trong Repo RideHub (As-Is)

Hiện tại, Consul được triển khai tại `infra/vps-infra/docker-compose.yml` với các thành phần:

1. **Service Registration qua FQDN công khai (Tuân thủ Multi-VPS)**:
   - Các microservice đăng ký vào Consul bằng địa chỉ định tuyến FQDN HTTPS (`msuser.phungvip.io.vn:443`) thay vì IP nội bộ `localhost` hay IP bridge docker. Điều này cho phép Gateway ở VPS 1 gọi sang Microservice ở VPS 2 một cách thông suốt.
2. **Consul Config Loader (`central-server-config/consul/consul-loader.sh`)**:
   - Tự động nạp các file YAML cấu hình trong `central-server-config/consul/KV/` lên các prefix:
     * `config/application/data` (Cấu hình dùng chung).
     * `config/ms_user/data`, `config/ms_booking/data`... (Cấu hình riêng từng service).
   - Tự động khởi tạo Master ACL Token và các service tokens.
3. **Consul KV Watcher (`sync-kv-to-files.sh`)**:
   - Lắng nghe sự thay đổi trên giao diện Consul UI và tự động ghi ngược về file YAML cục bộ để tránh mất mát cấu hình khi container bị xóa.

---

## 3. Những hạn chế & Tiềm năng chưa khai thác

| Tiềm năng chưa khai thác | Hiện trạng thực tế tại RideHub | Rủi ro / Điểm nghẽn |
|---|---|---|
| **Ranh giới Consul KV & Vault KV** | Một số secret (như database password, JWT secret) vẫn còn nằm rải rác trong file KV của Consul. | Consul KV mặc định không mã hóa at-rest, bất kỳ ai có quyền truy cập Consul UI đều đọc được mật khẩu. |
| **Phân quyền Consul ACL nghiêm ngặt** | Đa số microservices đang kết nối với Consul ở chế độ ẩn danh (Anonymous) hoặc dùng chung token. | Bất kỳ service nào cũng có thể đọc/ghi đè key của service khác nếu không có ACL Token chặn path. |
| **Consul Service Mesh (Consul Connect)** | Giao tiếp liên microservice đi qua Nginx Reverse Proxy hoặc mạng Wireguard. | Chưa tận dụng được proxy sidecar Envoy của Consul để thực hiện mTLS tự động và chính sách Intention (Service A chỉ được phép gọi Service B). |
| **Tách biệt KV theo từng Submodule** | Toàn bộ file KV đang bị gộp chung trong thư mục `vps-infra/central-server-config/consul/KV`. | Vi phạm nguyên tắc độc lập submodule: khi developer sửa `ms_booking`, họ phải sang repo `vps-infra` để sửa KV. |

---

## 4. Bảng kế hoạch lộ trình (Consul Roadmap)

| Giai đoạn | Tính năng | Mục tiêu | Độ ưu tiên | Vị trí can thiệp |
|:---:|---|---|:---:|---|
| **P1** | **Tách KV về Submodule con** | Chuyển file KV về thư mục gốc của từng service (`ms_booking/consul-kv.yml`), CI/CD tự nạp lên Consul khi deploy. | **P0 (Cần làm ngay)** | • `backend/ms_*/consul-kv.yml`<br>• Script deploy CI/CD |
| **P2** | **Làm sạch Consul KV (Tách bí mật sang Vault)** | Chỉ để cấu hình phi bảo mật (timeout, logging, page size) tại Consul KV. Toàn bộ credentials chuyển 100% sang Vault. | **P1 (Bảo mật)** | • `central-server-config/consul/KV/` |
| **P3** | **Kích hoạt Consul ACL cho Microservices** | Cấp Consul Token riêng cho từng service với quyền hạn chỉ đọc đúng prefix `config/<service-name>`. | **P2 (Chuẩn hóa)** | • `central-server-config/consul/consul-loader.sh` |
| **P4** | **Consul Health Check & Auto Deregistration** | Tối ưu thời gian gỡ bỏ service chết (`deregister_critical_service_after=30s`) để tránh Gateway gửi request vào node lỗi. | **P2 (Độ ổn định)** | • `application.yml` của các microservices |
| **P5** | **Consul Connect Service Mesh (mTLS)** | Tự động hóa mã hóa mTLS giữa các microservices qua Envoy Sidecar. | **P3 (Nâng cao)** | • Cấu hình Docker Compose & Envoy |

---

## 5. Chi tiết kỹ thuật & Hướng dẫn triển khai

### A. Tách biệt Consul KV và Vault KV trong Spring Boot
Để kết hợp tối đa sức mạnh của cả hai công nghệ:
1. **Consul KV**: Giữ vai trò tải cấu hình động (Dynamic Hot Reload):
   ```yaml
   # Lưu tại Consul KV: config/ms_booking/data
   app:
     booking:
       hold-timeout-minutes: 10
       max-tickets-per-user: 5
     payment:
       sepay-enabled: true
   logging:
     level:
       com.ridehub.booking: DEBUG
   ```
   *Khi sửa giá trị này trên giao diện Consul, microservice có `@RefreshScope` sẽ tự cập nhật trong 1 giây mà KHÔNG cần restart!*

2. **Vault KV**: Giữ vai trò bảo vệ bí mật:
   ```yaml
   # Lưu tại Vault: secret/data/ridehub/ms_booking
   spring:
     datasource:
       password: "super_secret_db_password"
   sepay:
     api-token: "sepay_secret_token"
   ```

### B. Cấu hình Consul ACL Policy cho từng Microservice
Tránh để microservice sử dụng token ẩn danh:

1. **Định nghĩa Policy cho `ms_booking` (`ms-booking-consul-policy.hcl`)**:
   ```hcl
   # Cho phép đăng ký service discovery với tên ms-booking
   service "ms-booking" {
     policy = "write"
   }

   # Chỉ cho phép đọc config chung và config của chính nó
   key_prefix "config/application/" {
     policy = "read"
   }
   key_prefix "config/ms_booking/" {
     policy = "read"
   }

   # Cấm đọc key của các service khác
   key_prefix "config/ms_user/" {
     policy = "deny"
   }
   ```

2. **Tạo Token trên Consul**:
   ```bash
   consul acl policy create -name "ms-booking-policy" -rules @ms-booking-consul-policy.hcl
   consul acl token create -description "Token for ms_booking service" -policy-name "ms-booking-policy"
   ```

3. **Truyền Token vào Spring Boot qua biến môi trường**:
   ```yaml
   spring:
     cloud:
       consul:
         host: consul.phungvip.io.vn
         port: 443
         scheme: https
         config:
           acl-token: ${CONSUL_HTTP_TOKEN}
         discovery:
           acl-token: ${CONSUL_HTTP_TOKEN}
   ```

