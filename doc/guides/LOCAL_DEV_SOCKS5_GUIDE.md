# Hướng Dẫn Phát Triển Local (Zero-Install Local Dev Guide)

Tài liệu này hướng dẫn cách chạy và debug microservices tại máy cá nhân (Local) kết nối trực tiếp vào hạ tầng VPS (`phungvip.io.vn`) mà **không cần cài đặt bất kỳ phần mềm VPN, SSH hay cấu hình phức tạp nào**.

---

## 1. Nguyên Lý Hoạt Động

* **Consul & Keycloak & Gateway**: Kết nối trực tiếp qua HTTPS (`consul.phungvip.io.vn`, `keycloak.phungvip.io.vn`, `apigateway.phungvip.io.vn`).
* **Kafka**: Gửi/nhận event trực tiếp qua `kafka.phungvip.io.vn:9093` (SASL_SSL).
* **Consul Health Check**: Tự động gửi tín hiệu sống bằng **Consul Heartbeat (TTL)** (chiều Outbound, không cần mở cổng trên router Wi-Fi).
* **Database (MySQL) & Redis**: Kết nối qua **SOCKS5 Proxy** trên VPS (cổng `1080`).

---

## 2. Cách Kết Nối Database & Redis qua SOCKS5 Proxy

SOCKS5 Proxy được tích hợp sẵn trên VPS tại địa chỉ:
* **Host**: `phungvip.io.vn` (hoặc IP của VPS)
* **Port**: `1080`
* **Username**: `dev`
* **Password**: `<APP_F4_PASS>` (lấy từ biến `APP_F4_PASS` trong file `.env`)

### Cách A: Cấu hình qua VM Options trong IntelliJ IDEA (Khuyên dùng - 1 lần duy nhất)

Khi chạy bất kỳ microservice nào (`MsBookingApp`, `MsRouteApp`...) trong IntelliJ:
1. Vào **Run/Debug Configurations** của service.
2. Tại mục **VM options** (hoặc Modify options ➡️ Add VM options), thêm cờ:
   ```bash
   -DsocksProxyHost=phungvip.io.vn -DsocksProxyPort=1080 -Djava.net.socks.username=dev -Djava.net.socks.password=<APP_F4_PASS>
   ```
3. Bấm **Apply** và **Run**.
👉 Toàn bộ kết nối TCP của Spring Boot (MySQL JDBC, Redis) sẽ tự động luồn qua SOCKS5 Proxy vào thẳng database trên VPS!

### Cách B: Cấu hình trực tiếp trong DBeaver / DataGrip (Để xem và sửa Database)

Nếu bạn muốn dùng DBeaver xem dữ liệu MySQL trên VPS:
1. Tạo kết nối MySQL mới trong DBeaver:
   * **Host**: `localhost` (hoặc tên container `ms_booking-mysql`)
   * **Port**: `3309` (port MySQL tương ứng của service)
   * **Username**: `root`
   * **Password**: `<APP_F4_PASS>`
2. Chuyển sang tab **Network Handler** ➡️ Chọn **SOCKS Proxy**:
   * Tích chọn **Use SOCKS Proxy**
   * **Host**: `phungvip.io.vn` | **Port**: `1080`
   * **Username**: `dev` | **Password**: `<APP_F4_PASS>`
3. Bấm **Test Connection** ➡️ Thành công!

---

## 3. Cách Dùng Thư Viện Dùng Chung (`ridehub-shared`)

### Khi code ở Local:
Mỗi khi bạn chỉnh sửa mã nguồn trong `infra/shared/ridehub-contract` hoặc `infra/shared/ridehub-shared`:
```bash
cd infra/shared/ridehub-contract && ./mvnw clean install -DskipTests
cd ../ridehub-shared && ./mvnw clean install -DskipTests
```
* File JAR sẽ được cập nhật ngay lập tức vào thư mục `~/.m2` máy bạn trong 3 giây.
* Tất cả microservices khác sẽ nhận ngay code mới mà không cần mạng.

### Khi kéo từ kho Reposilite:
Tất cả các microservices đã được cấu hình sẵn repository:
```xml
<repository>
    <id>ridehub-releases</id>
    <name>RideHub Reposilite Releases</name>
    <url>https://repo.phungvip.io.vn/releases</url>
</repository>
```
* Tải tự do (Anonymous Read), **hoàn toàn không cần GitHub Personal Access Token (PAT)**.

---

## 4. Kích Hoạt Deploy Tự Động (Webhook)

Khi cần kích hoạt restart hoặc deploy microservice trên VPS từ xa (hoặc từ GitHub Actions):
```bash
# Deploy toàn bộ:
curl -X POST "https://webhook.phungvip.io.vn/hooks/restart?target=all" -H "X-Admin-Token: <ADMIN_TOKEN>"

# Hoặc deploy riêng 1 service:
curl -X POST "https://webhook.phungvip.io.vn/hooks/restart?target=ms_booking" -H "X-Admin-Token: <ADMIN_TOKEN>"
```
