# HẠ TẦNG: HASHICORP VAULT (SECRETS & DATA PROTECTION)

> **Phạm vi quản lý**: Quản trị bí mật tập trung (Secrets Management), Mã hóa dữ liệu người dùng (Encryption-as-a-Service), Xác thực danh tính qua Keycloak SSO và cấp phát thông tin đăng nhập động (Dynamic Credentials).

---

## 1. Bản chất & Cơ chế hoạt động của Vault

Khác với các kho lưu trữ thông thường (như Consul KV hay file `.env`), HashiCorp Vault là một giải pháp bảo mật toàn diện:
* **Zero Trust & Lease-based**: Mọi secret truy xuất đều đi kèm thời hạn thuê (lease/TTL). Khi hết hạn, secret sẽ bị thu hồi.
* **Encryption-at-Rest & In-Transit**: Mọi dữ liệu lưu trong storage của Vault đều được mã hóa bằng thuật toán AES-256-GCM.
* **Audit Trail**: Ghi log chi tiết danh tính (Identity), thời gian, địa chỉ IP của bất kỳ ai đọc hoặc sửa đổi secret.
* **Secrets Engines Plugin**: Cho phép Vault không chỉ lưu chuỗi tĩnh mà còn có khả năng sinh user database tạm thời, ký chứng chỉ SSL, mã hóa dữ liệu mà không lộ Private Key.

---

## 2. Hiện trạng đã triển khai trong Repo RideHub (As-Is)

Hiện tại, Vault được khởi chạy thông qua `infra/vps-infra/docker-compose.yml` và được khởi tạo tự động bằng script `infra/vps-infra/central-server-config/vault/vault-startup.sh`:

1. **KV Secrets Engine v2 (`secret/`)**:
   - Khởi tạo tại mount path `secret/`.
   - Script tự động quét toàn bộ file `.env`, chuyển các biến `UPPER_SNAKE_CASE` thành `kebab-case` và lưu vào đường dẫn `secret/infrastructure`.
   - Lưu trữ các chứng chỉ Kafka TLS tại `secret/common-kafka`.
2. **Xác thực OIDC với Keycloak (`Auth Methods -> oidc/`)**:
   - Kích hoạt OIDC Auth Method kết nối trực tiếp với Keycloak Realm `jhipster` (`https://keycloak.<DOMAIN>/realms/jhipster`).
   - Tự động map các Roles của Keycloak (`ROLE_ADMIN`, `ROLE_DEVOPS`) thành Vault Identity Groups thông qua Accessor ID của cổng OIDC (`auth_oidc_...`).
3. **Phân quyền RBAC (Access Control List Policies)**:
   - Đã nạp các policy: `admin-policy`, `dev-policy`, `qa-policy`, `microservices-readonly`.
4. **Service Tokens tĩnh**:
   - Sinh token dài hạn (`VAULT_TOKEN`, `APP_F4_PASS`) gắn với policy `microservices-readonly` và lưu vào `vault-tokens.env` để các dịch vụ khác sử dụng.

---

## 3. Những hạn chế & Tiềm năng chưa khai thác

| Tiềm năng chưa khai thác | Hiện trạng thực tế tại RideHub | Rủi ro / Điểm nghẽn |
|---|---|---|
| **Spring Cloud Vault Integration** | Các microservice Spring Boot (`ms_user`, `ms_booking`...) vẫn đang đọc biến cấu hình qua biến môi trường Docker Compose. | Khi cần đổi password hay API key, bắt buộc phải sửa file môi trường và restart toàn bộ container. |
| **AppRole Authentication** | Tất cả microservice đang dùng chung 1 token tĩnh (`VAULT_TOKEN`) với quyền đọc `secret/infrastructure`. | Vi phạm nguyên tắc Principle of Least Privilege. Nếu 1 service bị chiếm quyền, kẻ tấn công đọc được toàn bộ secret của các service khác. |
| **Transit Secrets Engine** | Thông tin cá nhân hành khách (CCCD, SĐT, số tài khoản ngân hàng) được lưu dạng plaintext trong MySQL. | Rủi ro lộ dữ liệu khách hàng nếu database bị SQL Injection hoặc rò rỉ file backup. |
| **Dynamic Database Credentials** | MySQL sử dụng tài khoản `root` hoặc static user cấu hình sẵn trong docker-compose. | Mật khẩu database vĩnh viễn không được xoay vòng (credential rotation). |
| **Production Storage & Auto-Unseal** | Vault đang chạy chế độ dev server (`vault server -dev`). | Dữ liệu lưu trong RAM/temp storage, có nguy cơ mất cấu hình động nếu container bị recreate mà không có persistent volume chuẩn. |

---

## 4. Bảng kế hoạch lộ trình (Vault Roadmap)

| Giai đoạn | Tính năng | Mục tiêu | Độ ưu tiên | Vị trí can thiệp |
|:---:|---|---|:---:|---|
| **P1** | **AppRole & Spring Cloud Vault** | Cấp RoleID & SecretID riêng cho từng service; Spring Boot tự kéo config từ Vault khi bootstrap. | **P0 (Cần làm ngay)** | • `central-server-config/vault/vault-startup.sh`<br>• `infra/shared/ridehub-shared`<br>• `backend/ms_*/bootstrap.yml` |
| **P2** | **Transit Engine (Mã hóa PII)** | Mã hóa dữ liệu nhạy cảm của khách hàng (CCCD, GPLX, Bank Account) trước khi lưu vào DB. | **P1 (Bảo mật cốt lõi)** | • Bật `transit/`<br>• Entity Listener trong `ms_user`, `ms_booking` |
| **P3** | **Database Secrets Engine** | Tạo user MySQL tạm thời (TTL 1h) cho Spring Boot, tự động xoay vòng mật khẩu DB. | **P2 (Nâng cấp)** | • Cấu hình MySQL plugin trong Vault<br>• Spring Cloud Vault Database config |
| **P4** | **SSH Secrets Engine** | Cấp SSH OTP tạm thời cho kỹ sư DevOps đăng nhập vào các máy chủ VPS. | **P2 (Vận hành VPS)** | • Cấu hình SSHD trên các VPS |
| **P5** | **Production Storage & Auto-Unseal** | Chuyển sang Raft Integrated Storage, tự động mở khóa Vault bằng Cloud KMS khi restart VPS. | **P3 (Độ sẵn sàng)** | • `central-server-config/vault/vault.hcl` |

---

## 5. Chi tiết kỹ thuật & Hướng dẫn triển khai

### A. Giai đoạn 1: Triển khai AppRole cho từng Microservice
Mỗi microservice cần có một danh tính độc lập thay vì dùng chung token:

1. **Kích hoạt AppRole và tạo Policy cho `ms_user`**:
   ```bash
   vault auth enable approle

   # Tạo policy riêng cho ms_user
   vault policy write ms-user-policy - <<EOF
   path "secret/data/ridehub/common/*" {
     capabilities = ["read"]
   }
   path "secret/data/ridehub/ms_user/*" {
     capabilities = ["read"]
   }
   EOF

   # Tạo Role
   vault write auth/approle/role/ridehub-ms-user \
       token_policies="ms-user-policy" \
       token_ttl=1h \
       token_max_ttl=24h
   ```

2. **Lấy `role-id` và `secret-id`**:
   ```bash
   vault read auth/approle/role/ridehub-ms-user/role-id
   vault write -f auth/approle/role/ridehub-ms-user/secret-id
   ```

3. **Cấu hình Spring Boot (`bootstrap.yml`)**:
   ```yaml
   spring:
     cloud:
       vault:
         host: vault.phungvip.io.vn
         port: 443
         scheme: https
         authentication: APPROLE
         app-role:
           role-id: ${VAULT_ROLE_ID}
           secret-id: ${VAULT_SECRET_ID}
         kv:
           backend: secret
           default-context: ridehub/ms_user
   ```

---

### B. Giai đoạn 2: Mã hóa dữ liệu nhạy cảm với Transit Engine

1. **Bật Engine và tạo khóa AES**:
   ```bash
   vault secrets enable transit
   vault write -f transit/keys/customer-pii-key type=aes256-gcm96
   ```

2. **Cơ chế mã hóa / giải mã qua REST API**:
   * **Mã hóa (Encrypt)**:
     ```bash
     # Chuỗi "012345678901" base64 là "MDEyMzQ1Njc4OTAx"
     curl -s --header "X-Vault-Token: ..." \
       --request POST \
       --data '{"plaintext": "MDEyMzQ1Njc4OTAx"}' \
       https://vault.phungvip.io.vn/v1/transit/encrypt/customer-pii-key
     # Kết quả: "vault:v1:8bTvq..." (Lưu chuỗi này vào cột cccd trong MySQL)
     ```
   * **Giải mã (Decrypt)**:
     ```bash
     curl -s --header "X-Vault-Token: ..." \
       --request POST \
       --data '{"ciphertext": "vault:v1:8bTvq..."}' \
       https://vault.phungvip.io.vn/v1/transit/decrypt/customer-pii-key
     # Kết quả: Trả về base64 giải mã
     ```

3. **Tích hợp vào Java Entity (`ridehub-shared`)**:
   Tạo JPA AttributeConverter:
   ```java
   @Converter
   public class VaultTransitConverter implements AttributeConverter<String, String> {
       @Autowired
       private VaultTransitService transitService;

       @Override
       public String convertToDatabaseColumn(String attribute) {
           return transitService.encrypt("customer-pii-key", attribute);
       }

       @Override
       public String convertToEntityAttribute(String dbData) {
           return transitService.decrypt("customer-pii-key", dbData);
       }
   }
   ```
   Trong Entity:
   ```java
   @Convert(converter = VaultTransitConverter.class)
   @Column(name = "national_id")
   private String nationalId; // Số CCCD tự động được mã hóa khi lưu và giải mã khi đọc
   ```

