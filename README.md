# RideHub - Microservices Platform

RideHub là nền tảng đặt xe công nghệ (ride-sharing platform) xây dựng trên kiến trúc **Spring Boot 3.4 / JHipster 8.11 Microservices**, điều phối dịch vụ qua **Consul**, xác thực phân quyền qua **Keycloak OIDC**, và giao tiếp bất đồng bộ qua **Kafka KRaft**.

---

## 1. Mở khóa bí mật môi trường (.env) bằng Transcrypt

Dự án sử dụng **`transcrypt`** (AES-256-CBC) để mã hóa toàn bộ các file `.env` khi commit lên Git nhằm bảo vệ mật khẩu và API secrets.

Khi bạn vừa clone repository này về máy, hãy chạy lệnh sau để giải mã toàn bộ các file cấu hình `.env`:

```bash
transcrypt -c aes-256-cbc -p 'PASSWORD'
```

* **Xem cấu hình mã hóa hiện tại**: `transcrypt -d`
* **Đổi mật khẩu mã hóa (Rekey)**: `transcrypt -r`

> [!NOTE]
> File `.env` trên máy local của bạn sẽ ở dạng plain-text để IDE và Spring Boot đọc bình thường. Khi `git commit / push`, transcrypt sẽ tự động mã hóa nhị phân trước khi đẩy lên GitHub.

---

## 2. Kiến trúc hệ thống (Architecture)

```
                                  [ Client / Browser ]
                                           │
                                           ▼
                               [ gateway:8080 (Angular 19) ]
                                           │
             ┌─────────────────────────────┼─────────────────────────────┐
             ▼                             ▼                             ▼
    [ ms_user:8081 ]              [ ms_route:8082 ]             [ ms_booking:8083 ]
   (User & Driver Profiles)     (Trips, Seats, Routing)        (Bookings, Tickets, Pay)
             │                             │                             │
             └─────────────────────────────┼─────────────────────────────┘
                                           │
                                           ▼
                                [ ms_promotion:8084 ]
                               (Discounts & Campaigns)
                                           │
    ══════════════════════════════════════════════════════════════════════════════
    HẠ TẦNG DÙNG CHUNG (VPS INFRA):
    - Consul: Service Discovery & Distributed KV (Port 8500)
    - Keycloak: OAuth2 / OIDC Auth Server (Port 9080)
    - Kafka KRaft: Event Messaging Stream + Avro Envelope (Port 9093 / 9094)
    - Redis: Cache, Sessions & Distributed Locking (Port 6379)
    - Elasticsearch: Pathfinding & Geo-Search (Port 9200)
    - Observability: Prometheus (9090), Loki (3100), Grafana (3000)
    - Maven Repo: Reposilite (https://repo.phungvip.io.vn)
```

### Chi tiết các Microservices

| Service | Port | Database | Công nghệ & Nhiệm vụ chính |
|---|---|---|---|
| **gateway** | `8080` | MySQL | Spring Cloud Gateway, Angular 19 frontend, Reverse proxy, JWT Relay |
| **ms_user** | `8081` | MySQL | Quản lý người dùng, tài xế, xác thực OTP, hồ sơ cá nhân |
| **ms_route** | `8082` | MySQL | Quản lý chuyến xe, tuyến đường, ghế ngồi, Elasticsearch tìm kiếm |
| **ms_booking** | `8083` | MySQL | Đặt vé, giữ chỗ, thanh toán (VNPay, SePay), xuất hóa đơn |
| **ms_promotion**| `8084` | MySQL | Quản lý voucher, khuyến mãi, chính sách giảm giá |

---

## 3. Cấu trúc Git Submodules

Repository này là Monorepo điều phối chứa các Git submodules:

* `backend/gateway` $\rightarrow$ `https://github.com/phungle-vip/ridehub-gateway.git`
* `backend/ms_user` $\rightarrow$ `https://github.com/phungle-vip/ridehub-ms-user.git`
* `backend/ms_route` $\rightarrow$ `https://github.com/phungle-vip/ridehub-ms-route.git`
* `backend/ms_booking` $\rightarrow$ `https://github.com/phungle-vip/ridehub-ms-booking.git`
* `backend/ms_promotion` $\rightarrow$ `https://github.com/phungle-vip/ridehub-ms-promotion.git`
* `infra/shared/ridehub-contract` $\rightarrow$ `https://github.com/phungle-vip/ridehub-contract.git`
* `infra/shared/ridehub-shared` $\rightarrow$ `https://github.com/phungle-vip/ridehub-shared.git`
* `infra/vps-infra` $\rightarrow$ `https://github.com/phungle-vip/vps-infra.git`
* `infra/vps-microservices` $\rightarrow$ `https://github.com/phungle-vip/vps-microservices.git`

Khi clone repository mới:
```bash
git clone --recursive https://github.com/phungle2508/ridehub.git
# Hoặc nếu đã clone:
git submodule update --init --recursive
```

---

## 4. Hướng dẫn phát triển Local (Local Development)

### A. Phát triển từng Service riêng biệt
Chạy trực tiếp bất kỳ service nào trong thư mục của nó:
```bash
cd backend/ms_booking
./mvnw                       # Chạy Spring Boot ở profile dev
./mvnw verify                # Chạy Unit & Integration tests
```

Với **Gateway (Frontend)**:
```bash
cd backend/gateway
./mvnw                       # Chạy Gateway backend
./npmw start                 # Khởi động Angular dev server (http://localhost:9000)
./npmw test                  # Chạy Unit test frontend
```

### B. Kết nối Database & Redis qua SOCKS5 Proxy
Nếu muốn dev local kết nối thẳng vào DB và Redis trên VPS:
* Thêm VM options vào Run Configuration trong IntelliJ:
  ```bash
  -DsocksProxyHost=phungvip.io.vn -DsocksProxyPort=1080 -Djava.net.socks.username=dev -Djava.net.socks.password=PASSWORD
  ```

---

## 5. Quy trình làm việc với Shared Library (`infra/shared`)

Hệ thống tách biệt rõ ràng giữa Contract và Thư viện dùng chung:
* **`ridehub-contract`**: Chứa nguồn sự thật duy nhất (SSOT) cho Avro Schemas, OpenAPI Specs, AsyncAPI Specs.
* **`ridehub-shared`**: Chứa Feign Clients auto-generated, Kafka Utilities, Security Auth Interceptor.

### Vòng lặp phát triển nhanh (Không cần push Reposilite liên tục):
1. Đặt version `SNAPSHOT` (vd: `1.1.0-SNAPSHOT`) trong `pom.xml`.
2. Sửa schema trong `ridehub-contract` hoặc sinh lại Feign trong `ridehub-shared`:
   ```bash
   cd infra/shared/ridehub-shared
   ./mvnw clean package -Prun-openapi -DskipTests
   ```
3. Cài đặt vào Local Maven Repo (`~/.m2`):
   ```bash
   cd infra/shared/ridehub-contract && ./mvnw clean install -DskipTests
   cd ../ridehub-shared && ./mvnw clean install -DskipTests
   ```
4. Các microservice (`ms_booking`, `ms_route`...) sẽ nhận ngay code mới trong 5 giây!

> Chi tiết quy trình và lưu ý xem tại: [`infra/shared/CONTRACT_WORKFLOW_GUIDE.txt`](infra/shared/CONTRACT_WORKFLOW_GUIDE.txt)

---

## 6. Build & Deploy Production

```bash
# Build production JAR
./mvnw -Pprod clean verify

# Build Docker images
npm run java:docker             # Cho Gateway
./mvnw -Pprod jib:dockerBuild   # Cho các Microservices
```

