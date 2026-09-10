# Quick Connect Cheat Sheet (CLI Only)

---

## 1. ADMIN SSH — WINDOWS (PowerShell)

```powershell
# 1. Cai dat cloudflared
winget install Cloudflare.cloudflared

# 2. Cau hinh ~/.ssh/config
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

# 3. Dang nhap 1 lan qua trinh duyet
cloudflared access login https://ssh.phungvip.io.vn

# 4. Ket noi SSH
ssh ridehub
# hoac truc tiep IP:
ssh ridehub-direct
```

---

## 2. ADMIN SSH — LINUX (Arch / Ubuntu / Debian)

```bash
# 1. Cai dat cloudflared
# Arch Linux:
sudo pacman -S cloudflared
# Ubuntu / Debian:
# sudo apt update && sudo apt install cloudflared

# 2. Cau hinh ~/.ssh/config & Socket tang toc
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

# 3. Dang nhap & Ket noi
cloudflared access login https://ssh.phungvip.io.vn
ssh ridehub
```

---

## 3. DEVELOPER WARP (CODE LOCAL) — WINDOWS (PowerShell)

```powershell
# 1. Cai dat WARP
winget install Cloudflare.WARP

# 2. Dang ky vao Team appf4 (1 lan duy nhat)
warp-cli registration new appf4

# 3. Bat ket noi mang noi bo VPS
warp-cli connect

# 4. Kiem tra trang thai
warp-cli status

# 5. Ngat ket noi
warp-cli disconnect
```

---

## 4. DEVELOPER WARP (CODE LOCAL) — LINUX (Bash)

```bash
# 1. Cai dat WARP
# Arch Linux:
yay -S cloudflare-warp-bin
# Ubuntu / Debian:
# sudo apt update && sudo apt install cloudflare-warp

# 2. Khoi dong service ngam
sudo systemctl enable --now warp-svc

# 3. Dang ky vao Team appf4 (1 lan duy nhat)
warp-cli registration new appf4

# 4. Bat ket noi
warp-cli connect
warp-cli status

# 5. Ngat ket noi
warp-cli disconnect
```

---

## 5. INTERNAL IPs CHEAT SHEET (application-dev.yml)

```yaml
# VPS Infra (172.18.0.0/16)
spring.kafka.bootstrap-servers: 172.18.0.x:9092
spring.data.redis.host: 172.18.0.x
spring.data.redis.port: 6379
spring.cloud.consul.host: 172.18.0.x
spring.cloud.consul.port: 8500

# VPS Microservices (172.19.0.0/16)
spring.datasource.url:
  ms_user: jdbc:mysql://172.19.0.x:3308/ms_user
  ms_route: jdbc:mysql://172.19.0.x:3307/ms_route
  ms_booking: jdbc:mysql://172.19.0.x:3309/ms_booking
  ms_promotion: jdbc:mysql://172.19.0.x:3310/ms_promotion
```
