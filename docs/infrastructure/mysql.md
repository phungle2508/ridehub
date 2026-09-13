# HẠ TẦNG: MYSQL (DATABASE-PER-SERVICE & PERSISTENT STORAGE)

> **Phạm vi quản lý**: Quản trị cơ sở dữ liệu quan hệ (RDBMS), Triết lý cách ly dữ liệu độc lập (Database-per-Service), Quản lý phiên bản cấu trúc bảng (Liquibase Migrations), Tối ưu Connection Pool (HikariCP) và Chiến lược sao lưu khôi phục thảm họa (Backup & Disaster Recovery).

---

## 1. Bản chất & Cơ chế hoạt động của MySQL trong Microservices

MySQL là lớp lưu trữ dữ liệu bền vững (ACID) cốt lõi của RideHub:
* **Triết lý Database-per-Service (Bất di bất dịch)**: Mỗi microservice sở hữu toàn quyền một cơ sở dữ liệu riêng biệt. Tuyệt đối **CẤM** tạo foreign key hoặc truy vấn SQL chéo giữa DB của `ms_user` và `ms_booking`.
* **Liquibase Schema Versioning**: Mọi thay đổi về bảng, cột, index phải được viết dưới dạng mã lệnh di trú (changelog XML/YAML) và lưu ngay bên trong repository của service đó. Khi service khởi động, Liquibase tự động kiểm tra và nâng cấp bảng một cách an toàn.
* **HikariCP Connection Pooling**: Quản lý vòng đời kết nối từ Spring Boot tới MySQL, tối ưu thời gian mượn/trả kết nối và tự động phục hồi kết nối bị đứt do mạng chập chờn giữa các VPS.

---

## 2. Hiện trạng đã triển khai trong Repo RideHub (As-Is)

Hiện tại, MySQL được cấu hình dưới dạng các container phân lập chạy image `mysql:9.2.0`:

1. **Phân lập Container rõ ràng**:
   * Mỗi service có container DB riêng: `ms_user-mysql`, `ms_booking-mysql`, `ms_route-mysql`, `ms_promotion-mysql` và `keycloak-mysql`.
   * Cổng 3306 chỉ mở trong mạng nội bộ docker bridge hoặc mạng Wireguard, không public cổng 3306 ra ngoài Internet.
2. **Liquibase Migration độc lập**:
   * Từng submodule backend chứa toàn bộ changelog trong `src/main/resources/config/liquibase/changelog/`.
   * Tuân thủ quy tắc JDL Code Hygiene: Không sửa changelog cũ đã chạy, luôn thêm file migration mới khi bổ sung cột.
3. **Sao lưu tự động (`central-server-config/scripts/backup-vps.sh`)**:
   * Tự động đóng gói các volume dữ liệu MySQL và đẩy lên Google Drive định kỳ thông qua công cụ `rclone`.

---

## 3. Những hạn chế & Tiềm năng chưa khai thác

| Tiềm năng chưa khai thác | Hiện trạng thực tế tại RideHub | Rủi ro / Điểm nghẽn |
|---|---|---|
| **Phân tách Đọc / Ghi (Read-Write Splitting)** | Tất cả câu lệnh `SELECT` và `INSERT/UPDATE` đều dồn vào 1 node MySQL duy nhất. | Khi hàng triệu người dùng cùng vào xem tìm kiếm chuyến xe (`ms_route`), DB có thể bị quá tải CPU làm chậm luôn cả luồng đặt vé và thanh toán. |
| **Xoay vòng thông tin đăng nhập (Credential Rotation)** | Username và Password MySQL đang là chuỗi tĩnh lưu trong `.env`. | Mật khẩu không bao giờ được đổi định kỳ, vi phạm tiêu chuẩn bảo mật PCI-DSS trong thanh toán. |
| **Phục hồi theo thời gian thực (Point-in-Time Recovery - PITR)** | Mới chỉ backup dạng snapshot định kỳ hàng ngày (dump volume). | Nếu server gặp sự cố vào lúc 23:59, toàn bộ dữ liệu giao dịch vé trong ngày hôm đó có nguy cơ bị mất. |
| **Lưu trữ dữ liệu lịch sử (Data Archiving / Partitioning)** | Bảng `booking` và `ticket` lưu dồn toàn bộ dữ liệu từ trước đến nay vào 1 bảng duy nhất. | Sau 1-2 năm, bảng lên tới hàng chục triệu dòng làm các câu lệnh query bị chậm rõ rệt (Table Scan). |

---

## 4. Bảng kế hoạch lộ trình (MySQL Roadmap)

| Giai đoạn | Tính năng | Mục tiêu | Độ ưu tiên | Vị trí can thiệp |
|:---:|---|---|:---:|---|
| **P1** | **Tối ưu HikariCP & MySQL Slow Query Log** | Tinh chỉnh Connection Pool (`maximum-pool-size=20`, `idle-timeout`) và bật log truy vấn chậm > 500ms. | **P0 (Cần làm ngay)** | • `backend/ms_*/application.yml`<br>• MySQL my.cnf |
| **P2** | **Point-in-Time Recovery (PITR) với Binlog** | Bật MySQL Binary Log (`binlog`), tự động sync binlog sang Cloud Storage mỗi 15 phút để khôi phục dữ liệu tới từng giây. | **P1 (An toàn dữ liệu)** | • `central-server-config/scripts/` |
| **P3** | **Read-Write Splitting cho `ms_route` & `ms_booking`** | Thiết lập 1 MySQL Primary (Ghi) và 1 MySQL Read-Replica (Đọc) để giảm 70% tải cho DB chính. | **P1 (Mở rộng quy mô)** | • Spring AbstractRoutingDataSource |
| **P4** | **Phân vùng dữ liệu (Table Partitioning theo Tháng)** | Tự động phân vùng bảng `booking` theo cột `created_at` (mỗi tháng 1 partition riêng). | **P2 (Hiệu năng lâu dài)** | • Liquibase changelog của `ms_booking` |
| **P5** | **Tích hợp Vault Dynamic Database Secrets** | Chuyển việc quản lý user/pass sang Vault; tự tạo tài khoản tạm cho Spring Boot với TTL 1 giờ. | **P2 (Bảo mật tối đa)** | • Tích hợp Vault Database Engine |

---

## 5. Chi tiết kỹ thuật & Hướng dẫn triển khai

### A. Tối ưu cấu hình HikariCP trong Microservices (`application.yml`)
Tránh lỗi cạn kiệt Connection (`ConnectionTimeoutException`) khi có đột biến lưu lượng:

```yaml
spring:
  datasource:
    hikari:
      pool-name: RideHub-HikariCP
      maximum-pool-size: 15         # Không nên đặt quá cao, 15-20 connection/service là tối ưu cho MySQL
      minimum-idle: 5               # Luôn giữ sẵn 5 kết nối rảnh rỗi
      idle-timeout: 300000          # 5 phút không dùng thì đóng bớt kết nối rảnh
      max-lifetime: 1800000         # 30 phút tự làm mới kết nối để tránh lỗi kết nối ma do firewall/VPN
      connection-timeout: 20000     # Chờ tối đa 20 giây để mượn kết nối trước khi ném lỗi
      leak-detection-threshold: 10000 # Cảnh báo trong log nếu 1 thread giữ connection quá 10 giây (dấu hiệu lộ connection)
```

### B. Cấu hình Binary Log phục vụ Point-in-Time Recovery
Thêm vào file cấu hình MySQL container (`my.cnf`):

```ini
[mysqld]
# Bật binary logging
log_bin = /var/log/mysql/mysql-bin.log
expire_logs_days = 7
max_binlog_size = 100M
binlog_format = ROW

# Bật slow query log để phát hiện các câu query chưa đánh index
slow_query_log = 1
slow_query_log_file = /var/log/mysql/slow.log
long_query_time = 0.5
```
*Khi cần khôi phục dữ liệu: Kỹ thuật viên chỉ cần bung bản backup snapshot gần nhất, sau đó chạy lệnh `mysqlbinlog --stop-datetime="2026-09-13 14:30:00" | mysql -u root -p` để phục hồi chính xác dữ liệu đến trước thời điểm xảy ra sự cố đúng 1 giây!*

