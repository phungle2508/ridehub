# Quick Connect & Execution Cheat Sheet (CONNECT_CLI)

> **Mục tiêu**: Hướng dẫn kết nối và thực thi tác vụ cho Developer và Admin sau khi toàn bộ hệ thống 2 VPS (Infra & Microservices) đã khởi chạy và khởi tạo thành công.

---

# PHẦN I: 👨‍💻 DÀNH CHO DEVELOPER (LOCAL CODING & TESTING)

Developer chỉ kết nối qua **Cloudflare WARP** để code local và gọi trực tiếp vào cơ sở dữ liệu/broker nội bộ, không có quyền SSH vào máy chủ.

## 1. Kết Nối Mạng Nội Bộ (Cloudflare WARP)

### A. Windows (PowerShell)
```powershell
# 1. Cài đặt WARP
winget install Cloudflare.WARP

# 2. Đăng ký vào Team appf4 (1 lần duy nhất)
warp-cli registration new appf4
# -> Trình duyệt tự động mở, đăng nhập tài khoản Keycloak của bạn

# 3. Bật kết nối vào mạng nội bộ VPS
warp-cli connect

# 4. Kiểm tra trạng thái
warp-cli status
# Status update: Connected

# 5. Ngắt kết nối khi xong việc
warp-cli disconnect
```

### B. Linux (Arch / Ubuntu / Debian)
```bash
# 1. Cài đặt WARP:
# Arch Linux: yay -S cloudflare-warp-bin
# Ubuntu / Debian: sudo apt update && sudo apt install cloudflare-warp

# 2. Khởi động background service
sudo systemctl enable --now warp-svc

# 3. Đăng ký vào Team appf4 (1 lần duy nhất)
warp-cli registration new appf4

# 4. Bật kết nối
warp-cli connect
warp-cli status

# 5. Ngắt kết nối
warp-cli disconnect
```

---

## 2. Bảng Endpoints Nội Bộ & Cấu Hình `application-dev.yml`

Khi đã bật WARP, cấu hình file `src/main/resources/config/application-dev.yml` trên máy local của bạn:

```yaml
# Cụm VPS Infra (172.18.0.0/16)
spring:
  kafka:
    bootstrap-servers: 172.18.0.x:9092  # Không SSL nội bộ
    # Hoặc qua FQDN công khai: kafka.phungvip.io.vn:9093 (SSL)
  data:
    redis:
      host: 172.18.0.x
      port: 6379
  cloud:
    consul:
      host: 172.18.0.x
      port: 8500
      discovery:
        enabled: true

# Cụm VPS Microservices (172.19.0.0/16) - Cổng Database riêng biệt:
  datasource:
    # ms_user:
    url: jdbc:mysql://172.19.0.x:3308/ms_user?useUnicode=true&characterEncoding=utf8&useSSL=false
    # ms_route:
    # url: jdbc:mysql://172.19.0.x:3307/ms_route?useUnicode=true&characterEncoding=utf8&useSSL=false
    # ms_booking:
    # url: jdbc:mysql://172.19.0.x:3309/ms_booking?useUnicode=true&characterEncoding=utf8&useSSL=false
    # ms_promotion:
    # url: jdbc:mysql://172.19.0.x:3310/ms_promotion?useUnicode=true&characterEncoding=utf8&useSSL=false
```

---

## 3. Cấu Hình Maven Thư Viện Dùng Chung `ridehub-shared`

Thêm server vào `~/.m2/settings.xml` để tải hoặc phát hành thư viện từ Reposilite:
```xml
<settings>
  <servers>
    <server>
      <id>ridehub-releases</id>
      <username>developer</username>
      <password><REPOSILITE_TOKEN></password>
    </server>
    <server>
      <id>ridehub-snapshots</id>
      <username>developer</username>
      <password><REPOSILITE_TOKEN></password>
    </server>
  </servers>
</settings>
```
* Repository URL: `https://repo.phungvip.io.vn/releases` (hoặc `/snapshots`)

---

## 4. Kiểm Thử API & Chạy E2E Tests

```bash
# 1. Kiểm tra API Gateway:
curl -sS https://apigateway.phungvip.io.vn/management/health

# 2. Gọi API dịch vụ qua Gateway:
curl -sS https://apigateway.phungvip.io.vn/services/msuser/management/health

# 3. Chạy kiểm thử tự động E2E Karate:
cd e2e-tests
mvn test
python3 -m http.server 8000 --directory target/karate-reports
# -> Mở trình duyệt xem báo cáo tại http://localhost:8000
```

---
---

# PHẦN II: 🛡️ DÀNH CHO ADMIN (SSH & VẬN HÀNH HỆ THỐNG)

Admin sở hữu quyền truy cập SSH vào máy chủ VPS thông qua **Cloudflare Zero Trust SSH** và quyền thực thi các kịch bản vận hành trung tâm.

## 1. Kết Nối Quản Trị SSH Qua Cloudflare Zero Trust

### A. Windows (PowerShell)
```powershell
# 1. Cài đặt cloudflared
winget install Cloudflare.cloudflared

# 2. Cấu hình ~/.ssh/config
$cf = (Get-Command cloudflared -ErrorAction SilentlyContinue).Source; if (-not $cf) { $cf = "cloudflared.exe" }
$cfg = @"
Host ridehub
    HostName ssh.phungvip.io.vn
    User phungvip
    IdentityFile ~/.ssh/google_compute_engine
    ProxyCommand "$cf" access ssh --hostname %h
    StrictHostKeyChecking no
    UserKnownHostsFile /dev/null

Host ridehub-direct
    HostName 136.85.105.222
    User phungvip
    IdentityFile ~/.ssh/google_compute_engine
    StrictHostKeyChecking no
    UserKnownHostsFile /dev/null
"@
New-Item -ItemType Directory -Path "$HOME\.ssh" -Force | Out-Null
Set-Content -Path "$HOME\.ssh\config" -Value $cfg -Encoding utf8

# 3. Đăng nhập SSO qua trình duyệt
cloudflared access login https://ssh.phungvip.io.vn

# 4. Kết nối SSH
ssh ridehub
# Hoặc IP trực tiếp khi khẩn cấp:
ssh ridehub-direct
```

### B. Linux (Bash)
```bash
# 1. Cài đặt cloudflared: sudo apt install cloudflared / sudo pacman -S cloudflared
# 2. Cấu hình ~/.ssh/config & Socket tăng tốc
mkdir -p ~/.ssh/sockets && chmod 700 ~/.ssh
cat << 'EOF' > ~/.ssh/config
Host ridehub
    HostName ssh.phungvip.io.vn
    User phungvip
    IdentityFile ~/.ssh/google_compute_engine
    ProxyCommand cloudflared access ssh --hostname %h
    StrictHostKeyChecking no
    UserKnownHostsFile /dev/null
    ControlMaster auto
    ControlPath ~/.ssh/sockets/%r@%h:%p
    ControlPersist 10m

Host ridehub-direct
    HostName 136.85.105.222
    User phungvip
    IdentityFile ~/.ssh/google_compute_engine
    StrictHostKeyChecking no
    UserKnownHostsFile /dev/null
EOF
chmod 600 ~/.ssh/config ~/.ssh/google_compute_engine

# 3. Đăng nhập & Kết nối
cloudflared access login https://ssh.phungvip.io.vn
ssh ridehub
```

---

## 2. Bảng 6 Web UIs Quản Trị Hệ Thống (Single Sign-On)

| Dịch vụ | Domain Public | Quyền / Tài khoản |
| :--- | :--- | :--- |
| **Grafana Monitoring** | `https://grafana.phungvip.io.vn` | `admin.phungvip` (`GrafanaAdmin`) |
| **Keycloak Admin Console** | `https://keycloak.phungvip.io.vn/admin` | `admin` |
| **Consul Service Mesh** | `https://consul.phungvip.io.vn` | Token: `CONSUL_MASTER_TOKEN` |
| **HashiCorp Vault** | `https://vault.phungvip.io.vn` | Token: `VAULT_DEV_ROOT_TOKEN_ID` |
| **Kafka UI** | `https://kafka-ui.phungvip.io.vn` | SSO Admin |
| **RedisInsight** | `https://redisinsight.phungvip.io.vn` | SSO Admin |
| **Reposilite Registry** | `https://repo.phungvip.io.vn` | User: `admin` |

---

## 3. Kịch Bản Vận Hành Thực Thi (Operations Runbooks)

```bash
# A. Sao lưu 5 volumes dữ liệu lên Google Drive (chạy trên VPS 1):
./central-server-config/scripts/backup-vps.sh

# B. Tái cấp chứng chỉ SSL Kafka khi đổi Domain:
./central-server-config/scripts/renew-kafka-ssl.sh phungvip.io.vn
docker compose restart kafka kafka-ui

# C. Nạp đè lại toàn bộ cấu hình Consul KV:
./central-server-config/scripts/reload-consul-kv.sh

# D. Khởi động lại Microservices từ xa qua Webhook REST API:
curl -sS -X POST "https://webhook.phungvip.io.vn/hooks/restart-service" \
     -H "X-Admin-Token: <ADMIN_TOKEN>" \
     -H "Content-Type: application/json" \
     -d '{"service": "ms_user"}'

# E. Kiểm tra sức khỏe toàn bộ Microservices:
curl -s -H "X-Consul-Token: <CONSUL_MASTER_TOKEN>" http://127.0.0.1:8500/v1/health/state/any | jq -r '.[] | "\(.ServiceName) | \(.Status)"'
```

