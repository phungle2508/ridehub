# RideHub - Keycloak, Grafana, Cloudflare Access/WARP Upgrade TODO

> Tài liệu đề xuất. Không tự động thay đổi code hoặc cấu hình production.

## 1. Mục tiêu

- Grafana dùng Keycloak để xác thực account và role.
- Grafana chỉ có 2 role nghiệp vụ:
  - `grafana-admin`: quản trị Grafana.
  - `grafana-viewer`: chỉ xem dashboard.
- Cloudflare Access tiếp tục bảo vệ đường truy cập vào Grafana.
- Có thể đổi account WARP/Cloudflare để test mà không phải sửa code hoặc đổi token thủ công trong ứng dụng.
- Có thể kiểm tra revoke khi user bị disable hoặc bị thu hồi role.

## 2. Hiện trạng cần lưu ý

- Realm chính đang dùng là `jhipster`.
- File realm có `registrationAllowed: true`, nhưng realm runtime có thể không giống file JSON nếu Keycloak đã được khởi tạo trước đó.
- Grafana hiện chưa được cấu hình đầy đủ Generic OAuth với Keycloak và role mapping.
- Grafana đang có nguy cơ được publish trực tiếp qua host port `3000`; production nên chỉ đi qua Nginx/Cloudflare Tunnel.
- Cloudflare Access là lớp bảo vệ hostname và session truy cập.
- WARP là lớp private network/device enrollment, không nên dùng để quyết định role Admin/Viewer của Grafana.
- Không nên dùng chung client `web_app` cho Grafana nếu có thể tạo client riêng.

## 3. Kiến trúc production đề xuất

```text
Keycloak realm: jhipster
  |
  +-- Client: grafana
  |     +-- Client role: grafana-admin
  |     +-- Client role: grafana-viewer
  |
  +-- Client: cloudflare-access
  +-- Client: web_app

User -> Cloudflare Access -> Grafana -> Keycloak OIDC
                               |
                               +-- grafana-admin  -> Grafana Admin
                               +-- grafana-viewer -> Grafana Viewer
```

Không tạo realm riêng cho Grafana trong phương án mặc định. Dùng cùng realm `jhipster` giúp user, session, revoke và audit được quản lý tập trung.

## 4. Keycloak cần nâng cấp

### 4.1. Tạo client riêng cho Grafana

Tạo client:

```text
Client ID: grafana
Protocol: openid-connect
Flow: Authorization Code
PKCE: S256
Implicit Flow: disabled
Direct Access Grants: disabled nếu không có nhu cầu đặc biệt
```

Redirect URI production:

```text
https://grafana.phungvip.io.vn/login/generic_oauth
```

Không dùng wildcard redirect URI nếu không cần.

### 4.2. Tạo đúng 2 role Grafana

```text
grafana-admin
grafana-viewer
```

Có thể gán qua group để vận hành dễ hơn:

```text
/grafana-admins
/grafana-viewers
```

Mapping:

```text
grafana-admin  -> Grafana Admin
grafana-viewer -> Grafana Viewer
Không có role  -> từ chối đăng nhập Grafana
```

Không map trực tiếp toàn bộ các role nghiệp vụ như `ROLE_ADMIN`, `ROLE_DEV`, `ROLE_MANAGER` vào Grafana.

### 4.3. Chính sách đăng ký user

Đối với Grafana production:

- Không bật public self-registration.
- Admin tạo user hoặc gửi invite theo quy trình kiểm soát.
- Bật verify email.
- Bật reset password có kiểm soát.
- Bật brute-force protection.
- Thu hồi session khi user nghỉ việc hoặc bị disable.

Nếu cần test đăng ký, dùng môi trường test hoặc group/user test riêng, không mở đăng ký công khai cho toàn bộ production.

### 4.4. Bảng Danh Mục Tài Khoản & Ma Trận Phân Quyền (Admin Directory & Access Matrix)

Dưới đây là danh mục tài khoản định danh chuẩn được quản lý tập trung tại Keycloak Realm `jhipster` dành cho quản trị viên và kiểm thử viên:

| Tài khoản | Nhóm Keycloak | Keycloak Roles | Quyền trên Grafana | Ghi chú & Mục đích sử dụng |
| :--- | :--- | :---: | :---: | :--- |
| `admin.phungvip` | `/Admins`, `/grafana-admins` | `ROLE_ADMIN`, `ROLE_DEV`, `grafana-admin` | 👑 **Admin** | Super Admin hạ tầng & hệ thống RideHub |
| `devops.lead` | `/Admins`, `/grafana-admins` | `ROLE_ADMIN`, `ROLE_DEV`, `grafana-admin` | 👑 **Admin** | Trưởng nhóm DevOps, CI/CD & Bảo mật |
| `grafana-admin-test` | `/grafana-admins` | `grafana-admin` | 👑 **Admin** | Tài khoản kiểm thử vai trò Admin trên Grafana |
| `grafana-viewer-test` | `/grafana-viewers` | `grafana-viewer` | 👁️ **Viewer** | Tài khoản kiểm thử vai trò Viewer (chỉ đọc) |
| `grafana-no-role-test`| `/Users` | *(Không có role Grafana)* | ⛔ **Từ chối (Deny)** | Tài khoản kiểm thử cơ chế chặn truy cập |
| `disabled-test` | `/Users` | *(Bị vô hiệu hóa - Disabled)* | ⛔ **Từ chối (Deny)** | Tài khoản kiểm thử cơ chế thu hồi quyền/khóa |

> **Quy tắc bảo mật**:
> - Grafana không lưu mật khẩu người dùng nội bộ (ngoại trừ tài khoản cứu hộ fallback). Toàn bộ xác thực danh tính được ủy quyền qua Keycloak OIDC.
> - Quản lý thêm mới, đổi mật khẩu, hoặc thu hồi quyền truy cập được thực hiện tập trung tại **Keycloak Admin Console**: `https://keycloak.phungvip.io.vn/admin/master/console/#/jhipster/users`.

## 5. Grafana cần nâng cấp

Cấu hình Generic OAuth với Keycloak:

```text
Auth URL:
https://keycloak.phungvip.io.vn/realms/jhipster/protocol/openid-connect/auth

Token URL:
https://keycloak.phungvip.io.vn/realms/jhipster/protocol/openid-connect/token

API URL:
https://keycloak.phungvip.io.vn/realms/jhipster/protocol/openid-connect/userinfo
```

Role mapping phải strict:

```text
grafana-admin  -> Admin
grafana-viewer -> Viewer
role khác      -> deny
```

Không tự động chuyển user không có role thành Viewer, vì sẽ tạo quyền ngoài ý muốn.

Phân biệt:

- Grafana `Viewer`: chỉ xem dashboard.
- Grafana `Admin`: quản trị trong organization.
- Grafana `Server Admin`: quyền toàn bộ instance, chỉ cấp cho nhóm cực kỳ hạn chế.

Tắt publish trực tiếp:

```text
Không expose 3000 ra public interface.
Cloudflare Tunnel -> Nginx -> Grafana:3000
```

## 6. Cloudflare Access và WARP

### 6.1. Có nên bỏ `appf4.cloudflareaccess.com` không?

Không nên bỏ. Tiếp tục dùng Cloudflare Access làm lớp bảo vệ bên ngoài.

Phân chia trách nhiệm:

```text
Cloudflare Access:
  - Ai được đi tới hostname Grafana.
  - Session edge và Access policy.
  - WARP/device enrollment/private network.

Keycloak + Grafana:
  - Account ứng dụng.
  - Role `grafana-admin` và `grafana-viewer`.
  - Disable user và revoke quyền ứng dụng.
```

Không tạo trang login riêng và không dùng Grafana làm trang quản lý Keycloak. Hai việc này làm tăng diện tích tấn công và tạo thêm nguồn dữ liệu user không đồng bộ.

### 6.1.1. Không dùng Grafana để chạy lệnh logout/WARP

Không nên tạo nút trong Grafana để thực thi trực tiếp các lệnh như:

```bash
warp-cli disconnect
warp-cli registration delete
warp-cli registration new appf4
warp-cli connect
```

hoặc gọi URL:

```text
https://appf4.cloudflareaccess.com/cdn-cgi/access/logout
```

Các thao tác này thuộc về thiết bị và browser của người dùng:

- URL logout phải được mở trong browser của user để xóa cookie Cloudflare Access/Keycloak. Gọi URL từ Grafana server sẽ không xóa cookie trên browser của user.
- `warp-cli` phải chạy trên laptop, VM hoặc thiết bị đang đăng ký WARP. Chạy từ Grafana server chỉ thay đổi WARP của server, không thay đổi WARP của laptop.
- Grafana có quyền chạy shell command sẽ trở thành command runner trên hạ tầng. Nếu bị chiếm quyền, attacker có thể chạy lệnh hệ điều hành, đọc secret hoặc điều khiển mạng private.
- Grafana alert webhook chỉ nên gửi event tới endpoint được allowlist; không nên dùng webhook để nhận shell command tùy ý.

Phương án an toàn hơn:

1. Tạo bookmark/browser shortcut cho URL Cloudflare logout.
2. Dùng browser profile riêng cho từng account test.
3. Dùng script local có allowlist lệnh và yêu cầu xác nhận trước khi đổi WARP registration.
4. Nếu cần nút quản trị tập trung, xây một admin tool riêng với các action cố định, authentication mạnh, audit log, rate limit và không nhận shell command tùy ý. Tool này vẫn cần agent/local helper chạy trên thiết bị user nếu muốn đổi WARP của thiết bị đó.

Grafana chỉ nên hiển thị hướng dẫn hoặc link logout, không nên là nơi thực thi các lệnh `warp-cli`.

### 6.1.2. Admin Tools cho Grafana, Consul và Vault

Grafana, Consul và Vault có thể được đặt link trong một khu vực quản trị riêng:

```text
Admin Tools
  +-- Grafana: https://grafana.phungvip.io.vn
  +-- Consul:  https://consul.phungvip.io.vn
  +-- Vault:   https://vault.phungvip.io.vn
  +-- Logout Cloudflare Access
```

Link logout chung:

```text
https://appf4.cloudflareaccess.com/cdn-cgi/access/logout
```

Link này chỉ logout session Cloudflare Access trong browser. Nó không tự động:

- Thu hồi Consul ACL token.
- Thu hồi Vault token hoặc lease.
- Xóa Grafana API key/service account token.
- Xóa registration hoặc session WARP trên thiết bị.
- Logout Keycloak nếu Keycloak còn giữ SSO session.

Vì vậy Admin Tools chỉ nên chứa link điều hướng và hướng dẫn revoke, không nhận hoặc thực thi token, shell command hay API request tùy ý.

Quyền đề xuất:

```text
Keycloak client role: grafana-admin
  -> Có thể thấy Admin Tools dashboard.

Keycloak client role: grafana-viewer
  -> Không thấy Admin Tools dashboard.

Consul ACL và Vault policy
  -> Vẫn được kiểm tra riêng bằng token/policy tương ứng.
```

Không dùng quyền Grafana Admin để suy ra quyền toàn quyền trong Consul hoặc Vault. Đây là các boundary bảo mật khác nhau.

### 6.2. Vấn đề đổi WARP user/token

WARP registration là trạng thái của **thiết bị**, không phải role Grafana. Nếu nhiều người dùng chung một registration hoặc một máy, session cũ có thể làm việc test account bị nhầm.

Không nên sửa token trong code hoặc nhúng token vào ứng dụng. Dùng một trong các cách sau:

#### Phương án khuyến nghị: mỗi account test một thiết bị/profile riêng

```text
warp-admin-test      -> thiết bị/profile A
warp-viewer-test     -> thiết bị/profile B
warp-no-role-test    -> thiết bị/profile C
```

Có thể dùng:

- Máy ảo riêng.
- User OS riêng.
- Laptop test riêng.
- VM/container có network namespace riêng nếu đội vận hành đã kiểm soát tốt.

Ưu điểm: session và registration không bị lẫn, dễ audit và dễ revoke từng thiết bị.

#### Phương án thực dụng: đổi registration trên cùng máy

`warp-cli registration delete` chỉ xóa registration của thiết bị WARP. Nó không logout cookie của browser khỏi Cloudflare Access hoặc Keycloak. Vì vậy cần xử lý browser session trước khi đăng nhập account mới.

Trình tự khuyến nghị:

1. Mở URL logout của Cloudflare Access:

```text
https://appf4.cloudflareaccess.com/cdn-cgi/access/logout
```

2. Logout khỏi Keycloak tại hostname Keycloak hoặc xóa site data/cookie của các domain:

```text
appf4.cloudflareaccess.com
keycloak.phungvip.io.vn
grafana.phungvip.io.vn
grafana-test.phungvip.io.vn
```

3. Đóng toàn bộ cửa sổ browser cũ hoặc mở một browser profile mới.
4. Sau đó mới đổi registration WARP:

```bash
warp-cli disconnect
warp-cli registration delete
warp-cli registration new appf4
warp-cli connect
warp-cli status
```

Tên lệnh có thể khác theo phiên bản WARP CLI. Kiểm tra trước bằng:

```bash
warp-cli --help
warp-cli registration --help
```

Sau đó đăng nhập bằng account Keycloak cần test trong browser profile mới. Không dùng lại tab cũ vì Cloudflare Access có thể tự động chuyển tiếp đến IdP với session hiện tại.

Nếu vẫn bị đăng nhập account cũ:

- Kiểm tra browser profile đang sử dụng có đúng profile test không.
- Xóa toàn bộ cookie/site data của cả Cloudflare Access và Keycloak.
- Đóng rồi mở lại browser sau khi xóa cookie.
- Thử cửa sổ ẩn danh để phân biệt lỗi cookie với lỗi policy.
- Nếu cửa sổ ẩn danh vẫn vào account cũ, kiểm tra session SSO còn tồn tại tại Keycloak và thực hiện logout Keycloak trước khi thử lại.

Lưu ý: `registration delete` sẽ xóa registration hiện tại của thiết bị. Chỉ dùng trên máy test hoặc khi đã có quy trình đăng ký lại.

#### Phương án vận hành tốt hơn: tách policy production và test

Tạo hai Access application/policy:

```text
Production:
  grafana.phungvip.io.vn
  Chỉ group được phép dùng production.

Test:
  grafana-test.phungvip.io.vn
  Chỉ group /AccessTest/*.
```

Dùng các user test:

```text
grafana-admin-test   -> grafana-admin

grafana-viewer-test  -> grafana-viewer

grafana-no-role-test -> không có role Grafana
```

Không đưa user test vào policy production chỉ để thử role.

## 7. Quy trình test đổi account

Mỗi account dùng một browser profile riêng:

```text
Browser Profile: grafana-admin-test
Browser Profile: grafana-viewer-test
Browser Profile: grafana-no-role-test
```

Với mỗi lần đổi account:

1. Logout Cloudflare Access bằng `/cdn-cgi/access/logout`.
2. Logout Keycloak hoặc xóa site data của Cloudflare Access, Keycloak và Grafana.
3. Đóng browser profile cũ hoặc chuyển sang profile mới.
4. Ngắt WARP nếu đang đổi device registration.
5. Xóa registration cũ hoặc chuyển sang thiết bị/profile riêng.
6. Đăng nhập lại `appf4` bằng account test.
7. Mở Grafana test hoặc Grafana production theo policy được cấp.
8. Kiểm tra role hiển thị và hành động thực tế trong Grafana.
9. Ghi lại account, device, thời gian, role và kết quả.

Không dùng việc WARP kết nối thành công để kết luận user có role Grafana. WARP chỉ chứng minh user được vào private network.

## 8. Quy trình test revoke

### 8.1. Revoke role

1. Xóa `grafana-admin` khỏi user hoặc group trong Keycloak.
2. Revoke Keycloak user sessions.
3. Đăng xuất Grafana.
4. Xóa session Cloudflare Access nếu policy cũng thay đổi.
5. Đăng nhập lại bằng cùng account.
6. Xác nhận user không còn quyền Admin.

### 8.2. Disable user

1. Disable user trong Keycloak.
2. Revoke active sessions, refresh token và offline token.
3. Revoke Cloudflare Access session/device nếu user không còn được phép vào network.
4. Xóa Grafana API key hoặc service account token của user nếu có.
5. Thử lại bằng browser và WARP session cũ.
6. Xác nhận access token cũ không còn tạo được quyền mới.

Access token đã phát có thể còn hiệu lực đến khi hết hạn. Vì vậy cần kiểm thử cả token cũ, refresh token và session trình duyệt.

## 9. Ma trận test tối thiểu

| Account | Keycloak role | Cloudflare Access | Grafana |
|---|---|---|---|
| `grafana-admin-test` | `grafana-admin` | Allow | Admin |
| `grafana-viewer-test` | `grafana-viewer` | Allow | Viewer |
| `grafana-no-role-test` | Không có role Grafana | Có thể vào Access nhưng bị Grafana từ chối | Deny |
| `disabled-test` | Đã disable | Deny hoặc session bị thu hồi | Deny |

Kiểm tra thêm:

- Viewer không tạo/sửa/xóa datasource.
- Viewer không quản trị user.
- Admin thực hiện được đúng quyền organization.
- User không có role không được default thành Viewer.
- User bị xóa role không giữ quyền Admin sau khi session được revoke.
- WARP user không thuộc nhóm được phép không đăng ký được thiết bị.

## 10. Các việc ưu tiên nâng cấp

### P0 - Bắt buộc trước production

- [x] Tạo client Keycloak riêng cho Grafana (đã cấu hình trong `jhipster-realm.json`).
- [x] Tạo đúng hai client role `grafana-admin` và `grafana-viewer`.
- [x] Cấu hình Grafana Generic OAuth và strict role mapping (trong `vps-infra/docker-compose.yml`).
- [x] Không cho user không có role đăng nhập Grafana (`ROLE_ATTRIBUTE_STRICT=true`).
- [x] Tiếp tục bảo vệ Grafana bằng Cloudflare Access (đã thêm vào `setup-cloudflare-access.sh`).
- [x] Không expose trực tiếp port `3000` (đã chuyển sang `expose: - "3000"`).
- [ ] Rotate credential/client secret đang lưu plaintext.
- [x] Bật brute-force protection và quy trình revoke.

### P1 - Nên làm

- [ ] Tạo hostname `grafana-test` và policy test riêng.
- [x] Tạo bộ account test Admin/Viewer/No-role/Disabled (đã cấu hình trong `jhipster-realm.json` & `keycloak-users.env`).
- [x] Dùng browser profile hoặc thiết bị riêng cho từng account.
- [ ] Viết checklist test revoke định kỳ.
- [ ] Ghi audit log đăng nhập, đổi role và revoke.
- [ ] Giới hạn WARP enrollment theo group thay vì `everyone`.

### P2 - Có thể làm sau

- [ ] Tự động provisioning/deprovisioning qua Keycloak Admin API hoặc event listener.
- [ ] Tự động kiểm thử role Grafana trong pipeline.
- [ ] Đồng bộ dashboard/folder permissions theo team nếu số lượng user tăng.
- [ ] Tạo break-glass account riêng, có thời hạn và audit bắt buộc.

## 11. Kết luận

Phương án mặc định cho RideHub production là:

```text
Giữ realm jhipster.
Tạo client grafana riêng.
Dùng 2 role grafana-admin và grafana-viewer.
Giữ Cloudflare Access appf4.cloudflareaccess.com.
Dùng WARP chỉ cho private network.
Dùng browser profile/thiết bị riêng để đổi account test.
Không tạo portal login riêng.
Không mở public self-registration cho Grafana production.
```
