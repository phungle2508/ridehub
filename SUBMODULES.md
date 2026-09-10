# CẤU TRÚC GIT SUBMODULES & MÃ HÓA TRANSCRYPT (.ENV)

> Tài liệu hướng dẫn chi tiết về cấu trúc các Git Submodule độc lập, quy trình clone, cập nhật mã nguồn và quản lý bí mật môi trường (`.env`) bằng Transcrypt trong hệ thống **RideHub**.

---

## 1. Danh mục các Git Submodules

Repository gốc `ridehub` đóng vai trò điều phối (orchestration), kết nối 10 Git Submodules độc lập:

| Đường dẫn cục bộ | Git Repository URL | Mô tả chức năng |
|---|---|---|
| `backend/gateway` | `https://github.com/phungle-vip/ridehub-gateway.git` | API Gateway (Spring Cloud Gateway) & Web Client (Angular 19) |
| `backend/ms_user` | `https://github.com/phungle-vip/ridehub-ms-user.git` | Quản lý người dùng, tài xế, hồ sơ & xác thực OTP |
| `backend/ms_route` | `https://github.com/phungle-vip/ridehub-ms-route.git` | Quản lý tuyến đường, chuyến xe, xe, Elasticsearch tìm kiếm |
| `backend/ms_booking` | `https://github.com/phungle-vip/ridehub-ms-booking.git` | Đặt vé, giữ chỗ, tích hợp thanh toán VNPay, SePay |
| `backend/ms_promotion` | `https://github.com/phungle-vip/ridehub-ms-promotion.git` | Quản lý khuyến mãi, voucher giảm giá |
| `infra/shared/ridehub-contract` | `https://github.com/phungle-vip/ridehub-contract.git` | Nguồn sự thật duy nhất (SSOT): Avro schemas & OpenAPI specs |
| `infra/shared/ridehub-shared` | `https://github.com/phungle-vip/ridehub-shared.git` | Thư viện Feign client, Kafka utils, Security interceptors |
| `infra/vps-infra` | `https://github.com/phungle-vip/vps-infra.git` | Cụm hạ tầng trung tâm: Consul, Keycloak, Kafka, Redis, Vault |
| `infra/vps-microservices` | `https://github.com/phungle-vip/vps-microservices.git` | Điều phối Docker Compose, Cloudflare Tunnel & Nginx Microservices |
| `e2e-tests` | `https://github.com/phungle-vip/ridehub-e2e-tests.git` | Bộ kiểm thử tích hợp đầu cuối Karate Framework |

---

## 2. Quy trình Clone & Cập nhật Submodules

### A. Clone mới toàn bộ repository cùng submodules:
```bash
git clone --recursive https://github.com/phungle2508/ridehub.git
cd ridehub
```

### B. Nếu đã clone nhưng chưa tải submodules:
```bash
git submodule update --init --recursive
```

### C. Cấu hình tự động cập nhật đệ quy:
```bash
git config submodule.recurse true
git config fetch.recurseSubmodules on-demand
```

### D. Kéo code mới nhất từ tất cả submodules:
```bash
git pull --recurse-submodules
git submodule update --remote --merge
```

---

## 3. Quản lý Môi trường (.env) bằng Transcrypt

Dự án sử dụng **`transcrypt`** (chuẩn mã hóa AES-256-CBC) để mã hóa toàn bộ file `.env` khi commit lên Git nhằm bảo vệ mật khẩu, secrets và token.

### A. Khởi tạo giải mã Transcrypt cho tất cả submodules (Chỉ chạy 1 lần sau khi clone):
```bash
export TRANSCRYPT_PASSWORD="YOUR_PASSPHRASE"

git submodule foreach --recursive '
   if ! git config --local --get transcrypt.version >/dev/null; then
      transcrypt -c aes-256-cbc -p "$TRANSCRYPT_PASSWORD" -y
   fi
'

unset TRANSCRYPT_PASSWORD
```

### B. Cơ chế hoạt động:
* Khi checkout hoặc pull: Transcrypt tự giải mã file `.env` trong working tree thành dạng plain-text để IDE và ứng dụng chạy bình thường.
* Khi commit hoặc push: Transcrypt tự động mã hóa nhị phân trước khi đẩy lên remote GitHub.

### C. Các lệnh tiện ích:
* **Kiểm tra trạng thái mã hóa hiện tại**:
  ```bash
  transcrypt -d
  ```
* **Đổi mật khẩu mã hóa (Rekey)**:
  ```bash
  transcrypt -r
  ```

---

## 4. Nguyên tắc làm việc trên từng Submodule

1. **Vào thư mục con để thao tác Git**:
   Mỗi submodule là một git repository hoàn chỉnh. Khi cần commit hoặc push code của service nào, `cd` trực tiếp vào thư mục đó:
   ```bash
   cd backend/ms_booking
   git checkout main
   git commit -am "feat: update booking flow"
   git push origin main
   ```
2. **Cập nhật tham chiếu (Commit Pointer) ở Root Repo**:
   Sau khi push code ở submodule con, quay lại thư mục root để commit con trỏ commit mới:
   ```bash
   cd ../..
   git add backend/ms_booking
   git commit -m "chore: bump ms_booking commit pointer"
   git push origin main
   ```
