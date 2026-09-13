# HẠ TẦNG: KEYCLOAK (IDENTITY & ACCESS MANAGEMENT - OIDC/SSO)

> **Phạm vi quản lý**: Định danh người dùng (Identity Provider), Đăng nhập một lần (Single Sign-On - SSO), Ủy quyền dựa trên vai trò (RBAC), Cấp phát và xác thực JSON Web Token (JWT / OAuth2 / OpenID Connect).

---

## 1. Bản chất & Cơ chế hoạt động của Keycloak

Keycloak là trung tâm kiểm soát danh tính và quyền truy cập (IAM) duy nhất trong hệ sinh thái RideHub:
* **Chuẩn OIDC & OAuth2**: Cung cấp các endpoint chuẩn hóa quốc tế (`/protocol/openid-connect/token`, `/certs`, `/.well-known/openid-configuration`) để Gateway, Microservices, Frontend và Vault cùng tin cậy xác thực.
* **Stateless JWT Verification**: Khi người dùng đăng nhập thành công, Keycloak ký một JWT bằng Private Key (thuật toán RS256). Các microservice chỉ cần lấy Public Key từ endpoint `/certs` của Keycloak một lần để tự động giải mã và kiểm tra tính hợp lệ của token mà không cần gọi ngược lại Keycloak ở mỗi request.
* **Role-Based Access Control (RBAC)**: Định nghĩa các vai trò hệ thống (`ROLE_ADMIN`, `ROLE_USER`, `ROLE_DRIVER`) và nhúng trực tiếp vào claim `roles` của JWT.

---

## 2. Hiện trạng đã triển khai trong Repo RideHub (As-Is)

Keycloak được triển khai tại `infra/vps-infra/docker-compose.yml` (phiên bản Keycloak 26 trên nền Quarkus):

1. **Realm `jhipster` tự động khởi tạo**:
   - Sử dụng template `central-server-config/keycloak/jhipster-realm.json.template`.
   - Script `keycloak-entrypoint.sh` tự động thay thế biến `${DOMAIN}` để nạp FQDN chuẩn (`keycloak.phungvip.io.vn`) tránh lỗi chuyển hướng sai domain.
2. **Cấu hình Clients chuẩn**:
   - `web_app`: Client dành cho Angular Frontend và Gateway xác thực người dùng cuối.
   - `internal`: Client kiểu `client_credentials` dành cho giao tiếp M2M (Machine-to-Machine) giữa các microservice nội bộ.
3. **Tích hợp SSO với các công cụ Hạ tầng**:
   - Kết nối trực tiếp với **HashiCorp Vault** qua OIDC Auth Method: Người dùng có vai trò `ROLE_ADMIN` hoặc `ROLE_DEVOPS` trên Keycloak tự động được phân quyền `admin-policy` khi vào giao diện Vault.
   - Tích hợp bảo vệ các trang quản trị hạ tầng đằng sau Cloudflare Access.

---

## 3. Những hạn chế & Tiềm năng chưa khai thác

| Tiềm năng chưa khai thác | Hiện trạng thực tế tại RideHub | Rủi ro / Điểm nghẽn |
|---|---|---|
| **Giao tiếp M2M (Service-to-Service)** | Một số lời gọi Feign Client nội bộ chưa sử dụng chuẩn Token Relay hoặc Client Credentials của Keycloak. | Nguy cơ thiếu kiểm soát truy cập giữa các microservices nội bộ. |
| **Xác thực 2 bước (MFA / 2FA)** | Tài khoản Quản trị viên (Admin) và Tài xế (Driver) chỉ đăng nhập bằng mật khẩu cơ bản. | Nguy cơ bị chiếm đoạt tài khoản quản trị khi lộ mật khẩu. |
| **Social Logins (Google / Apple)** | Mới chỉ hỗ trợ đăng ký tài khoản truyền thống bằng email/username. | Trải nghiệm người dùng đặt vé chưa tối ưu so với xu hướng đăng nhập 1 chạm qua Google/Apple. |
| **User Federation / SMS OTP Provider** | Tạo OTP đăng nhập cho tài xế đang xử lý riêng ở `ms_user` thay vì tích hợp sâu vào Authentication Flow của Keycloak. | Phân mảnh luồng xác thực: vừa có OTP ở `ms_user`, vừa có mật khẩu ở Keycloak. |
| **Keycloak High Availability (Clustering)** | Đang chạy 1 container Keycloak đơn lẻ trên 1 VPS. | Nếu container Keycloak bị lỗi, toàn bộ hệ thống không thể đăng nhập hoặc làm mới token. |

---

## 4. Bảng kế hoạch lộ trình (Keycloak Roadmap)

| Giai đoạn | Tính năng | Mục tiêu | Độ ưu tiên | Vị trí can thiệp |
|:---:|---|---|:---:|---|
| **P1** | **Chuẩn hóa Token Relay & Feign Client** | Đảm bảo Feign Client giữa các microservice luôn truyền kèm JWT Token của người dùng (giữ nguyên ngữ cảnh User). | **P0 (Cần làm ngay)** | • `infra/shared/ridehub-shared` (Security Interceptor) |
| **P2** | **Kích hoạt Bắt buộc 2FA cho Admin/Tài xế** | Ép buộc tài khoản có `ROLE_ADMIN` hoặc `ROLE_DRIVER` phải quét mã Google Authenticator (TOTP) khi đăng nhập. | **P1 (Bảo mật)** | • Keycloak Realm Settings (Authentication Execution Flow) |
| **P3** | **Tích hợp Google / Apple Social Login** | Thêm Identity Provider (Google, Apple) vào Realm `jhipster` cho khách hàng đặt vé trên Web/App. | **P1 (Trải nghiệm UX)** | • Keycloak Identity Providers config |
| **P4** | **Custom SMS/Zalo OTP Authenticator** | Đưa luồng đăng nhập số điện thoại qua mã OTP (SMS/Zalo ZNS) thành 1 bước xác thực chuẩn bên trong Keycloak. | **P2 (Hợp nhất)** | • Keycloak SPI (Custom Authentication Provider) |
| **P5** | **Clustering đa VPS với Infinispan** | Thiết lập Keycloak Cluster phân tán 2 node trên 2 VPS khác nhau sử dụng WireGuard VPN. | **P3 (Độ sẵn sàng cao)** | • `vps-infra/docker-compose.yml` (cache-ispn) |

---

## 5. Chi tiết kỹ thuật & Hướng dẫn triển khai

### A. Chuẩn hóa Security Interceptor cho Feign Client (`ridehub-shared`)
Khi `ms_booking` gọi sang `ms_user` qua Feign Client, cần tự động chuyển tiếp token của người dùng hiện tại (Token Relay):

```java
@Component
public class FeignClientTokenRelayInterceptor implements RequestInterceptor {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_TOKEN_TYPE = "Bearer";

    @Override
    public void apply(RequestTemplate template) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            String tokenValue = jwtAuthenticationToken.getToken().getTokenValue();
            template.header(AUTHORIZATION_HEADER, String.format("%s %s", BEARER_TOKEN_TYPE, tokenValue));
        }
    }
}
```

### B. Cấu hình M2M Token (Machine-to-Machine) khi chạy tác vụ nền
Đối với các tác vụ chạy ngầm (Scheduled Cron Jobs, Kafka Event Consumers) không có người dùng tương tác, service sử dụng tài khoản `internal` để lấy token:

```bash
# Xin token M2M từ Keycloak
curl -s -X POST "https://keycloak.phungvip.io.vn/realms/jhipster/protocol/openid-connect/token" \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "grant_type=client_credentials" \
  -d "client_id=internal" \
  -d "client_secret=${INTERNAL_CLIENT_SECRET}"
```
*Token trả về chứa các service role cần thiết để gọi API giữa các microservices một cách hợp lệ mà không bị 401 Unauthorized.*

