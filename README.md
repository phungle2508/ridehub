# RideHub - Microservices Platform

RideHub là nền tảng đặt xe công nghệ (ride-sharing platform) xây dựng trên kiến trúc **Spring Boot 3.4 / JHipster 8.11 Microservices**, điều phối dịch vụ qua **Consul**, xác thực phân quyền qua **Keycloak OIDC**, và giao tiếp bất đồng bộ qua **Kafka KRaft**.

---

## 1. Khởi động nhanh (Quick Start)

### A. Clone & Giải mã biến môi trường (.env)
```bash
# 1. Clone repository kèm toàn bộ submodules
git clone --recursive https://github.com/phungle2508/ridehub.git
cd ridehub

# 2. Giải mã file .env bằng Transcrypt (chỉ cần chạy 1 lần)
export TRANSCRYPT_PASSWORD="YOUR_PASSPHRASE"
git submodule foreach --recursive '
   if ! git config --local --get transcrypt.version >/dev/null; then
      transcrypt -c aes-256-cbc -p "$TRANSCRYPT_PASSWORD" -y
   fi
'
unset TRANSCRYPT_PASSWORD
```
> 👉 Chi tiết cấu trúc từng submodule và cách quản lý Git xem tại: [**`SUBMODULES.md`**](SUBMODULES.md)

### B. Chạy thử Local Service
```bash
# Chạy bất kỳ microservice nào:
cd backend/ms_booking && ./mvnw

# Chạy Gateway & Angular Frontend:
cd backend/gateway && ./mvnw           # Terminal 1: Backend
cd backend/gateway && ./npmw start     # Terminal 2: Angular (http://localhost:9000)
```

---

## 2. Kiến trúc hệ thống (System Architecture)

```
                              [ Client / Mobile App / Browser ]
                                              │
                                              ▼
                                 [ gateway:8080 (Angular 19) ]
                                              │
         ┌──────────────────────────────┼──────────────────────────────┐
         ▼                              ▼                              ▼
  [ ms_user:8081 ]              [ ms_route:8082 ]             [ ms_booking:8083 ]
 (User & Driver)              (Trips, Seats, Search)         (Bookings & Payment)
         │                              │                              │
         └──────────────────────────────┼──────────────────────────────┘
                                        ▼
                             [ ms_promotion:8084 ]
                            (Discounts & Campaigns)
══════════════════════════════════════════════════════════════════════════════════
HẠ TẦNG DÙNG CHUNG (VPS INFRA):
Consul (8500) | Keycloak OIDC (9080) | Kafka KRaft (9093) | Redis (6379) | Vault (8200)
```

### Danh mục Microservices

| Service | Port | Database | Nhiệm vụ chính |
|---|---|---|---|
| **gateway** | `8080` | MySQL | Spring Cloud Gateway, Angular 19 UI, Reverse proxy, JWT Relay |
| **ms_user** | `8081` | MySQL | Quản lý người dùng, tài xế, xác thực OTP, hồ sơ cá nhân |
| **ms_route** | `8082` | MySQL | Quản lý chuyến xe, tuyến đường, ghế ngồi, Elasticsearch |
| **ms_booking** | `8083` | MySQL | Đặt vé, giữ chỗ, thanh toán (VNPay, SePay), xuất hoá đơn |
| **ms_promotion**| `8084` | MySQL | Quản lý voucher, khuyến mãi, chính sách giảm giá |

---

## 3. Quy trình làm việc với Shared Library

Hệ thống tách biệt rõ ràng giữa Schema/Contract và Code client dùng chung:
* **`infra/shared/ridehub-contract`**: Nguồn sự thật duy nhất (SSOT) cho Avro Schemas, OpenAPI Specs.
* **`infra/shared/ridehub-shared`**: Chứa Feign Clients sinh tự động, Kafka utilities, Security Interceptors (phân phối qua Maven Registry: `https://repo.phungvip.io.vn`).

> 👉 Chi tiết quy trình cập nhật schema & build shared lib: [**`infra/shared/CONTRACT_WORKFLOW_GUIDE.txt`**](infra/shared/CONTRACT_WORKFLOW_GUIDE.txt)

---

## 4. Build & Triển khai (Build & Deploy)

```bash
# Build production JAR cho service
./mvnw -Pprod clean verify

# Build Docker images
npm run java:docker             # Gateway
./mvnw -Pprod jib:dockerBuild   # Microservices
```

* Triển khai cụm hạ tầng: xem [**`infra/vps-infra/README.md`**](infra/vps-infra/README.md)
* Triển khai cụm microservices tự động: xem [**`infra/vps-microservices/README.md`**](infra/vps-microservices/README.md)

---

## 5. Quy tắc kiến trúc cốt lõi (Core Architecture Rules)

Tất cả AI Coding Assistants và Developers tham gia dự án **BẮT BUỘC** phải tuân thủ hướng dẫn tại:
👉 [**`AGENTS.md`**](AGENTS.md) (hoặc [**`GEMINI.md`**](GEMINI.md))

* **Submodule Autonomy**: Độc lập hoàn toàn về Git, build và vòng đời; không import chéo mã nguồn.
* **JDL Code Hygiene**: Mã nguồn nền tảng sinh tự động từ `doc/ridehub.jdl`. Hạn chế sửa trực tiếp CRUD auto-gen; bảo vệ code custom bằng `.jhipsterignore` và cấu trúc Side-by-Side (`custom/`).
  > 📘 **Người mới bắt đầu?** Xem cẩm nang chi tiết: [**`doc/guides/JDL_DEVELOPMENT_GUIDE.md`**](doc/guides/JDL_DEVELOPMENT_GUIDE.md) để tránh bị ghi đè mất code khi cập nhật JDL.
* **Database per Service**: Mỗi service sở hữu database riêng, cấm truy cập chéo DB.
* **Multi-VPS First**: Không hardcode localhost hay container nội bộ; định tuyến FQDN qua HTTPS và Consul Service Discovery; sẵn sàng phân tán dịch vụ trên nhiều máy chủ độc lập.
