# 🌐 CẨM NANG TOÀN TẬP: KIẾN TRÚC MẠNG DUAL-LAYER, WIREGUARD, CỔNG VPN & TƯỜNG LỬA UFW (MULTI-VPS RIDEHUB)

> **Mục tiêu**: Hợp nhất toàn bộ tài liệu thiết kế, cấu hình kỹ thuật và kịch bản vận hành mạng nội bộ cho hạ tầng phân tán 2 VPS của **RideHub** vào **MỘT FILE DUY NHẤT**.
> **Phạm vi bao phủ**: Mạng Dual-Layer (L7 vs L4), 3 Use Cases cốt lõi, WireGuard Kernel Mesh, Cổng VPN tự phục vụ (`https://vpn.phungvip.io.vn`), Thiết kế khai báo trên Grafana, và Ma trận Tường lửa UFW (Firewall Rules).

---

## 📑 MỤC LỤC
1. [Chương 1: Kiến Trúc Mạng Dual-Layer & 3 Use Cases Cốt Lõi](#chương-1-kiến-trúc-mạng-dual-layer--3-use-cases-cốt-lõi)
   - [1.1. Sơ đồ kiến trúc phân tầng](#11-sơ-đồ-kiến-trúc-phân-tầng)
   - [1.2. Ma trận giải quyết 3 bài toán (Admin SSH, VPS-to-VPS, Dev LAN)](#12-ma-trận-giải-quyết-3-bài-toán-admin-ssh-vps-to-vps-dev-lan)
   - [1.3. Chiến lược kết hợp Keycloak OIDC tối ưu hiệu năng](#13-chiến-lược-kết-hợp-keycloak-oidc-tối-ưu-hiệu-năng)
2. [Chương 2: Toàn Tập WireGuard – Mạng LAN Ảo Layer 4](#chương-2-toàn-tập-wireguard--mạng-lan-ảo-layer-4)
   - [2.1. Bản đồ phân bổ dải IP nội bộ (10.10.0.0/24)](#21-bản-đồ-phân-bổ-dải-ip-nội-bộ-10100024)
   - [2.2. Hướng dẫn cài đặt WireGuard trên Linux Kernel](#22-hướng-dẫn-cài-đặt-wireguard-trên-linux-kernel)
   - [2.3. Sinh cặp khóa bảo mật (Public/Private Key)](#23-sinh-cặp-khóa-bảo-mật-publicprivate-key)
   - [2.4. File cấu hình chi tiết từng Node (wg0.conf)](#24-file-cấu-hình-chi-tiết-từng-node-wg0conf)
   - [2.5. Kích hoạt và kiểm tra thông mạng](#25-kích-hoạt-và-kiểm-tra-thông-mạng)
   - [2.6. Cấu hình Microservices & Docker Compose khi kết nối qua WireGuard L4](#26-cấu-hình-microservices--docker-compose-khi-kết-nối-qua-wireguard-l4)
3. [Chương 3: Cổng Cấp VPN Tự Phục Vụ (`https://vpn.phungvip.io.vn`)](#chương-3-cổng-cấp-vpn-tự-phục-vụ-httpsvpnphungvpiovn)
   - [3.1. Kiến trúc container wg-easy](#31-kiến-trúc-container-wg-easy)
   - [3.2. Cấu hình Docker Compose mẫu cho wg-easy](#32-cấu-hình-docker-compose-mẫu-cho-wg-easy)
   - [3.3. Quy trình Dev nhận cấu hình VPN (.conf & QR Code)](#33-quy-trình-dev-nhận-cấu-hình-vpn-conf--qr-code)
   - [3.4. Phân quyền truy cập Web UI qua Cloudflare Zero Trust (RBAC Policy)](#34-phân-quyền-truy-cập-web-ui-qua-cloudflare-zero-trust-rbac-policy)
4. [Chương 4: Thiết Kế Khai Báo `https://vpn.phungvip.io.vn` Trong Grafana](#chương-4-thiết-kế-khai-báo-httpsvpnphungvpiovn-trong-grafana)
   - [4.1. Vị trí trên Dashboard Developer (dev-control & developer-docs)](#41-vị-trí-trên-dashboard-developer-dev-control--developer-docs)
   - [4.2. Vị trí trên Dashboard Ops/Admin (ops-control & admin-docs)](#42-vị-trí-trên-dashboard-opsadmin-ops-control--admin-docs)
5. [Chương 5: Toàn Tập Tường Lửa UFW (Firewall Rules & Zero Trust)](#chương-5-toàn-tập-tường-lửa-ufw-firewall-rules--zero-trust)
   - [5.1. Ma trận cổng & quyền truy cập (Port Matrix)](#51-ma-trận-cổng--quyền-truy-cập-port-matrix)
   - [5.2. Bộ lệnh thiết lập UFW trên VPS 1 (Infra Hub)](#52-bộ-lệnh-thiết-lập-ufw-trên-vps-1-infra-hub)
   - [5.3. Bộ lệnh thiết lập UFW trên VPS 2 (Microservices)](#53-bộ-lệnh-thiết-lập-ufw-trên-vps-2-microservices)
   - [5.4. Cơ chế "Trói chân" an toàn cho Developer](#54-cơ-chế-trói-chân-an-toàn-cho-developer)
   - [5.5. Xử lý bẫy nguy hiểm "Docker bypass UFW"](#55-xử-lý-bẫy-nguy-hiểm-docker-bypass-ufw)
6. [Chương 6: Cheatsheet Vận Hành & Khắc Phục Sự Cố](#chương-6-cheatsheet-vận-hành--khắc-phục-sự-cố)

---

## Chương 1: Kiến Trúc Mạng Dual-Layer & 3 Use Cases Cốt Lõi

### 1.1. Sơ đồ kiến trúc phân tầng

Hạ tầng phân tán 2 VPS của RideHub phân chia ranh giới rõ ràng thành 2 lớp:
- **Lớp Ngoài (Layer 7 - Public Ingress)**: Đi qua Cloudflare Ingress (HTTPS 443) tới API Gateway, Keycloak, Reposilite, Web Frontend.
- **Lớp Trong (Layer 4 - Private Overlay)**: Mạng LAN ảo **WireGuard Kernel (`10.10.0.0/24`)** kết hợp **Tường lửa UFW** cho toàn bộ backend (Kafka 9093, Redis 6379, 4x MySQL).

```text
[ Khách Hàng / Mobile App ]              [ Quản Trị Viên (Admin) ]              [ Lập Trình Viên (Dev) ]
             │                                      │                                      │
             ▼ (HTTPS Công Khai)                    ▼ (Browser Web Terminal)               ▼ (App WireGuard Client)
┌───────────────────────────────┐     ┌───────────────────────────────┐      ┌───────────────────────────────┐
│     CLOUDFLARE INGRESS        │     │    CLOUDFLARE ZERO TRUST      │      │     WIREGUARD VPN TUNNEL      │
│  - phungvip.io.vn             │     │  - ssh.phungvip.io.vn         │      │  - vpn.phungvip.io.vn         │
│  - gateway.phungvip.io.vn     │     │  - Check Keycloak OIDC Role:  │      │  - Cấp IP: 10.10.0.4+         │
│  - repo.phungvip.io.vn        │     │    ROLE_ADMIN / ROLE_DEVOPS   │      │  - UFW trói IP: Cấm SSH 22,   │
│  - keycloak.phungvip.io.vn    │     │  - Render Web Terminal đen    │      │    chỉ mở Kafka/Redis/MySQL   │
└───────────────┬───────────────┘     └───────────────┬───────────────┘      └───────────────┬───────────────┘
                │                                     │                                      │
                ▼ (Port 443 HTTPS)                    ▼                                      ▼ (Port 51820 UDP)
┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
│ 🔒 MẠNG LAN NỘI BỘ WIREGUARD KERNEL (10.10.0.0/24) + TƯỜNG LỬA UFW                                          │
├─────────────────────────────────────────────┬───────────────────────────────────────────────────────────────┤
│          VPS 1 (Infra Hub - 10.10.0.1)      │              VPS 2 (Microservices - 10.10.0.2)                │
├─────────────────────────────────────────────┼───────────────────────────────────────────────────────────────┤
│ • Keycloak OIDC (Port 9080)                 │ • Spring Cloud Gateway (Port 8080)                            │
│ • Kafka Broker SASL_SSL (Port 10.10.0.1:9093│ • Microservices: ms_user, ms_booking, ms_route, ms_promotion  │
│ • Redis Cache (Port 10.10.0.1:6379)         │ • 4 x MySQL Databases (Ports 10.10.0.2:3307 - 3310)           │
│ • HashiCorp Consul & Vault                  │ • Nginx Ingress Reverse Proxy                                 │
│ • Reposilite (Private Maven Registry)       │ • Observability Agents (Promtail, Prom-agent, cAdvisor)       │
│ • wg-easy (VPN Portal: vpn.phungvip.io.vn)  │                                                               │
│ • Observability Hub: Prometheus, Loki,      │                                                               │
│   Grafana, Kafdrop                          │                                                               │
└─────────────────────────────────────────────┴───────────────────────────────────────────────────────────────┘
```

---

### 1.2. Ma trận giải quyết 3 bài toán (Admin SSH, VPS-to-VPS, Dev LAN)

| Bài toán | Công nghệ lựa chọn | Trải nghiệm & Cơ chế bảo mật | Đánh giá hiệu năng |
|---|---|---|---|
| **Case 1: Admin SSH vào VPS** | **Cloudflare Zero Trust + Keycloak OIDC** | Mở trình duyệt vào `https://ssh.phungvip.io.vn`, đăng nhập Keycloak (kiểm tra claim `ROLE_ADMIN` / `ROLE_DEVOPS`) ➡️ Render Web Terminal đen trực tiếp trên trình duyệt. **Zero-client (không cần cài app)**. | Tiện dụng tối đa, bảo mật 2 lớp qua Cloudflare Edge. |
| **Case 2: VPS to VPS (Backend M2M)** | **WireGuard Kernel P2P + UFW** | VPS 2 kết nối trực tiếp sang VPS 1 qua IP nội bộ `10.10.0.1`. Kafka (9093) và Redis (6379) chỉ bind lắng nghe trên `10.10.0.1`, đóng kín 100% với Internet. | **Đỉnh cao**: Ping 1-3ms, RAM ~3MB, không token timeout, hoạt động bền bỉ 24/7. |
| **Case 3: Dev vào LAN để code** | **WireGuard Profile (`wg-easy`) + UFW Trói IP** | Dev truy cập `https://vpn.phungvip.io.vn` (xác thực Keycloak) để tải file `.conf` hoặc quét mã QR nạp vào app WireGuard. Tường lửa UFW **khóa chặt port 22**, chỉ cho phép vào đúng Kafka, Redis và MySQL phụ trách. | Test service liên thông siêu mượt, thu hồi quyền (offboarding) trong 0.1s khi dev nghỉ việc. |

---

### 1.3. Chiến lược kết hợp Keycloak OIDC tối ưu hiệu năng

* **❌ Chỗ KHÔNG DÙNG OIDC (Tránh nghẽn mạng & đứt socket)**:
  - Tầng mạng VPN kết nối giữa 2 VPS và kết nối máy Dev: Dùng thuần **Public Key của WireGuard**. Chạy trong Linux Kernel, không bị timeout token, không phụ thuộc vào tình trạng sống còn của Keycloak.
* ** Chỗ DÙNG OIDC (Bảo mật tập trung cho con người)**:
  - Web Terminal SSH (`ssh.phungvip.io.vn`).
  - Các Dashboard quản trị: Grafana, Kafdrop (Kafka UI), Consul, Vault, Reposilite.
  - Cổng tải VPN Portal (`vpn.phungvip.io.vn`).
* **🟡 Chỗ DÙNG TOKEN STATELESS (Tốc độ tối đa cho API)**:
  - Khi microservices gọi nhau: Sử dụng JWT Bearer Token. Microservice tự xác thực chữ ký token bằng Public Key lưu sẵn trong RAM (**dưới 0.1ms**), hoàn toàn không gửi request kiểm tra ngược về Keycloak.

---

## Chương 2: Toàn Tập WireGuard – Mạng LAN Ảo Layer 4

### 2.1. Bản đồ phân bổ dải IP nội bộ (`10.10.0.0/24`)

| Node | Vai trò | IP WireGuard | Port dịch vụ lắng nghe | Ghi chú |
|---|---|:---:|---|---|
| **VPS 1 (Infra Hub)** | Server / Listener | **`10.10.0.1`** | `51820/udp`, `9093`, `6379`, `22` | Mở duy nhất port `51820/udp` ra Internet. |
| **VPS 2 (Microservices)**| Client / Peer | **`10.10.0.2`** | `3306 - 3310`, `8080`, `22` | Tự động kết nối sang VPS 1 qua UDP 51820. |
| **Admin Laptop (Bạn)** | Quản trị viên | **`10.10.0.3`** | N/A | Toàn quyền SSH vào `10.10.0.1` và `10.10.0.2`. |
| **Dev Nam (Booking)** | Kỹ sư Backend | **`10.10.0.4`** | N/A | Chỉ được kết nối vào Kafka, Redis và DB Booking. |
| **Dev Backend khác** | Kỹ sư Backend | **`10.10.0.5+`**| N/A | Cấp phát tự động qua `vpn.phungvip.io.vn`. |

---

### 2.2. Hướng dẫn cài đặt WireGuard trên Linux Kernel

Chạy trên **cả 2 VPS** (Ubuntu 22.04/24.04 hoặc Debian 12):
```bash
sudo apt update && sudo apt install -y wireguard wireguard-tools

# Bật tính năng IP Forwarding trong nhân Linux:
sudo sed -i -e 's/#net.ipv4.ip_forward=1/net.ipv4.ip_forward=1/' /etc/sysctl.conf
sudo sysctl -p
```

---

### 2.3. Sinh cặp khóa bảo mật (Public/Private Key)

#### Trên VPS 1:
```bash
mkdir -p /etc/wireguard && cd /etc/wireguard
umask 077
wg genkey | tee vps1_private.key | wg pubkey > vps1_public.key
```

#### Trên VPS 2:
```bash
mkdir -p /etc/wireguard && cd /etc/wireguard
umask 077
wg genkey | tee vps2_private.key | wg pubkey > vps2_public.key
```

#### Cho Admin Laptop:
```bash
wg genkey | tee admin_private.key | wg pubkey > admin_public.key
```

---

### 2.4. File cấu hình chi tiết từng Node (`wg0.conf`)

#### 📁 File `/etc/wireguard/wg0.conf` trên VPS 1 (Infra Hub):
```ini
[Interface]
Address = 10.10.0.1/24
ListenPort = 51820
PrivateKey = <NOI_DUNG_VPS1_PRIVATE_KEY>

# PEER 1: VPS 2 (Microservices)
[Peer]
PublicKey = <NOI_DUNG_VPS2_PUBLIC_KEY>
AllowedIPs = 10.10.0.2/32

# PEER 2: Admin Laptop (Bạn)
[Peer]
PublicKey = <NOI_DUNG_ADMIN_PUBLIC_KEY>
AllowedIPs = 10.10.0.3/32

# PEER 3: Dev Nam (Booking)
[Peer]
PublicKey = <NOI_DUNG_DEV_NAM_PUBLIC_KEY>
AllowedIPs = 10.10.0.4/32
```

#### 📁 File `/etc/wireguard/wg0.conf` trên VPS 2 (Microservices):
```ini
[Interface]
Address = 10.10.0.2/24
PrivateKey = <NOI_DUNG_VPS2_PRIVATE_KEY>

# PEER: Kết nối về VPS 1
[Peer]
PublicKey = <NOI_DUNG_VPS1_PUBLIC_KEY>
Endpoint = <PUBLIC_IP_VPS_1>:51820
AllowedIPs = 10.10.0.0/24
PersistentKeepalive = 25
```

#### 📁 File profile nạp vào app WireGuard của Admin: `ridehub-admin.conf`:
```ini
[Interface]
Address = 10.10.0.3/24
PrivateKey = <NOI_DUNG_ADMIN_PRIVATE_KEY>
DNS = 1.1.1.1

[Peer]
PublicKey = <NOI_DUNG_VPS1_PUBLIC_KEY>
Endpoint = <PUBLIC_IP_VPS_1>:51820
AllowedIPs = 10.10.0.0/24
PersistentKeepalive = 25
```

---

### 2.5. Kích hoạt và kiểm tra thông mạng

```bash
# Bật service tự chạy cùng hệ thống (trên cả 2 VPS):
sudo systemctl enable --now wg-quick@wg0

# Kiểm tra trạng thái handshake:
sudo wg show

# Kiểm tra ping giữa 2 VPS:
ping -c 3 10.10.0.1   # Từ VPS 2 ping sang VPS 1
ping -c 3 10.10.0.2   # Từ VPS 1 ping sang VPS 2
```

---

### 2.6. Cấu hình Microservices & Docker Compose khi kết nối qua WireGuard L4

> 💡 **Câu hỏi then chốt**: *Khi có mạng WireGuard, các microservices có cần sửa mã nguồn Java không? Docker Compose và các biến môi trường thay đổi như thế nào?*

#### A. Mã nguồn Backend (Java / Spring Boot): **TUYỆT ĐỐI KHÔNG CẦN SỬA**
Toàn bộ mã nguồn microservices tuân thủ nghiêm ngặt **Rule 5 trong `AGENTS.md` (Zero Hardcode & Dynamic Configuration)**. Microservices không bao giờ hardcode IP mà luôn đọc từ biến môi trường (`${KAFKA_BROKERS}`, `${REDIS_HOST}`) hoặc nhận từ Consul KV. Do đó, **không có bất kỳ dòng code Java nào phải sửa đổi**.

#### B. So sánh môi trường Mock (1 máy) vs Môi trường Multi-VPS thật (WireGuard):
* **Môi trường Mock (chạy chung 1 máy)**:
  Cả `vps-infra` và `vps-microservices` cùng nằm trên 1 máy chủ vật lý, nên các container dùng `host.docker.internal:host-gateway` (trỏ về gateway của bridge `docker0`, thường là `172.17.0.1`).
* **Môi trường Multi-VPS thật (2 máy tách biệt)**:
  VPS 2 không thể dùng `host-gateway` để gọi sang VPS 1 được nữa. Lúc này mạng LAN ảo WireGuard chính là cây cầu nối:
  - VPS 1 (Infra Hub): IP WireGuard là `10.10.0.1`.
  - VPS 2 (Microservices): IP WireGuard là `10.10.0.2`.

#### C. Thay đổi cấu hình tại VPS 1 (`vps-infra/docker-compose.yml`):
Chuyển port binding của Kafka và Redis từ IP docker0 cũ (`172.17.0.1`) sang IP WireGuard (`10.10.0.1`):
```yaml
# Trong infra/vps-infra/docker-compose.yml:
services:
  kafka:
    ports:
      - "127.0.0.1:9093:9093"   # Cục bộ trên VPS 1
      - "10.10.0.1:9093:9093"    # Lắng nghe qua interface WireGuard (wg0) cho VPS 2 & Dev

  redis:
    ports:
      - "127.0.0.1:6379:6379"   # Cục bộ trên VPS 1
      - "10.10.0.1:6379:6379"    # Lắng nghe qua interface WireGuard (wg0)
```

#### D. Thay đổi cấu hình tại VPS 2 (`vps-microservices/docker-compose.yml`):
Có 2 cách linh hoạt (khuyên dùng **Cách 1** vì không cần sửa file `.env`):

* **Cách 1 (Khuyên dùng - Cập nhật `extra_hosts` trong Docker Compose)**:
  Trong block `x-common-extra-hosts` của `docker-compose.yml` trên VPS 2, thay vì map về `host-gateway`, ta map thẳng sang IP WireGuard `10.10.0.1`:
  ```yaml
  x-common-extra-hosts: &common-extra-hosts
    - "host.docker.internal:10.10.0.1"
    - "kafka.${DOMAIN}:10.10.0.1"
    - "redis.${DOMAIN}:10.10.0.1"
    - "${DOMAIN}:10.10.0.1"
  ```
  👉 Khi đó, toàn bộ Microservices vẫn gọi `kafka.phungvip.io.vn:9093` hay `redis.phungvip.io.vn:6379` như bình thường, và Docker tự phân giải sang IP `10.10.0.1` của VPS 1!

* **Cách 2 (Khai báo trực tiếp trong file `.env` của VPS 2)**:
  ```env
  # .env trên VPS 2
  KAFKA_BROKERS=10.10.0.1:9093
  REDIS_HOST=10.10.0.1
  REDIS_PORT=6379
  LOKI_URL=http://10.10.0.1:3100
  PROMETHEUS_REMOTE_WRITE_URL=http://10.10.0.1:9090/api/v1/write
  ```

---

## Chương 3: Cổng Cấp VPN Tự Phục Vụ (`https://vpn.phungvip.io.vn`)

### 3.1. Kiến trúc container `wg-easy`

Thay vì sửa file `wg0.conf` bằng tay mỗi khi có thêm lập trình viên, ta sử dụng container **`wg-easy`** (`ghcr.io/wg-easy/wg-easy`):

* Chạy trong Docker trên VPS 1, tốn **~25MB - 30MB RAM**.
* Cung cấp giao diện Web UI tại cổng nội bộ `51821`, được Cloudflare Tunnel và Nginx reverse proxy ra tên miền: `https://vpn.phungvip.io.vn`.
* Được bảo vệ bởi Cloudflare Zero Trust Access + Keycloak OIDC.

```text
[ Dev mở trình duyệt vào: https://vpn.phungvip.io.vn ]
                       │
                       ▼
         [ Cloudflare Zero Trust Access ]
        (Bắt buộc đăng nhập qua Keycloak OIDC)
                       │
                       ▼ (HTTPS qua Cloudflare Tunnel)
         [ Nginx Proxy trên VPS 1 ]
                       │
                       ▼
       [ Container Docker: wg-easy (:51821) ]
  (Tự động sinh cấu hình .conf & hiển thị Mã QR)
```

---

### 3.2. Cấu hình Docker Compose mẫu cho `wg-easy`

Thêm vào `infra/vps-infra/docker-compose.yml`:
```yaml
  wg-easy:
    image: ghcr.io/wg-easy/wg-easy:latest
    container_name: wg-easy
    restart: unless-stopped
    environment:
      - WG_HOST=103.x.y.1          # IP Public của VPS 1
      - PASSWORD_HASH=$$2a$$12$$... # Hash mật khẩu admin web
      - WG_PORT=51820
      - WG_DEFAULT_ADDRESS=10.10.0.x
      - WG_DEFAULT_DNS=1.1.1.1
      - WG_ALLOWED_IPS=10.10.0.0/24  # Split Tunneling chỉ đi qua mạng nội bộ
    volumes:
      - /etc/localtime:/etc/localtime:ro
      - ./central-server-config/wireguard:/etc/wireguard
    ports:
      - "51820:51820/udp"           # Nhận kết nối VPN WireGuard
      - "127.0.0.1:51821:51821/tcp" # Web UI chỉ mở cho Nginx/Cloudflare
    cap_add:
      - NET_ADMIN
      - SYS_MODULE
    sysctls:
      - net.ipv4.ip_forward=1
```

---

### 3.3. Quy trình cấp và nhận cấu hình VPN (.conf & QR Code)

Do `wg-easy` là công cụ siêu nhẹ hướng tới hiệu năng tối đa (không có hệ thống phân quyền đa người dùng nội bộ), quy trình cấp phát key diễn ra như sau:
1. **Admin/DevOps**: Truy cập `https://vpn.phungvip.io.vn` ➡️ Bấm **"New Client"** ➡️ Đặt tên (ví dụ: `dev-phung`) ➡️ Hệ thống tự động gán IP tĩnh trong dải `10.10.0.4+` và sinh cặp key.
2. **Phân phối cho Developer**: Admin tải file `dev-phung.conf` hoặc gửi ảnh mã QR cho Developer qua kênh bảo mật nội bộ (hoặc Dev tra cứu thông số tại Grafana `developer-docs`).
3. **Developer nạp cấu hình**: Mở ứng dụng WireGuard (trên máy tính hoặc điện thoại), bấm **Import tunnel from file / QR code** ➡️ Bấm **Activate** ➡️ Kết nối ngay vào mạng LAN nội bộ trong **3 giây**.
4. **Thu hồi quyền (Offboarding)**: Khi một lập trình viên nghỉ việc, Admin chỉ cần vào `wg-easy` bấm nút **Delete** hoặc gạt tắt toggle của client đó. Quyền truy cập bị cắt ngay lập tức trong **0.1 giây**.

---

### 3.4. Phân quyền truy cập Web UI qua Cloudflare Zero Trust (RBAC Policy)

> ⚠️ **Cảnh báo bảo mật**: Vì giao diện Web của `wg-easy` có quyền tạo/xóa toàn bộ các kết nối VPN trong hệ thống, **tuyệt đối không mở tự do cho mọi role vào Web UI này**!

Hệ thống sử dụng **Cloudflare Zero Trust Access** kết hợp **Keycloak OIDC claim `roles`** để kiểm soát chặt chẽ:

```hcl
# Khai báo trong infra/orchestration/terraform/main.tf:
resource "cloudflare_zero_trust_access_application" "vpn_portal" {
  zone_id                   = var.cloudflare_zone_id
  name                      = "RideHub VPN Management Portal"
  domain                    = "vpn.${var.domain}"
  type                      = "self_hosted"
  session_duration          = "8h"
  auto_redirect_to_identity = true
  allowed_idps              = [cloudflare_zero_trust_access_identity_provider.keycloak.id]
}

resource "cloudflare_zero_trust_access_policy" "vpn_admin_only" {
  application_id = cloudflare_zero_trust_access_application.vpn_portal.id
  zone_id        = var.cloudflare_zone_id
  name           = "Allow Only Admin and DevOps"
  decision       = "allow"
  precedence     = 1

  include {
    oidc {
      claim_name  = "roles"
      claim_value = "ROLE_ADMIN"
    }
  }
  include {
    oidc {
      claim_name  = "roles"
      claim_value = "ROLE_DEVOPS"
    }
  }
}
```

* **Kết quả thực thi**:
  - 🛡️ **Admin / DevOps Lead** (có role `ROLE_ADMIN` / `ROLE_DEVOPS`): Đăng nhập Keycloak thành công ➡️ Được phép vào Web UI để cấp/thu hồi key.
  - 🚫 **Lập trình viên / User thường** (chỉ có role `ROLE_DEV` / `ROLE_USER`): Khi truy cập `https://vpn.phungvip.io.vn` sẽ bị Cloudflare chặn đứng ngay tại Gateway với thông báo **`403 Access Denied`**. Điều này loại bỏ hoàn toàn nguy cơ lập trình viên vô tình hay cố ý xóa mất key của người khác.

---

## Chương 4: Thiết Kế Khai Báo `https://vpn.phungvip.io.vn` Trong Grafana

> 📌 **Lưu ý**: Đây là thiết kế quy hoạch tài liệu (Documented Blueprint). Khi triển khai thực tế, nội dung này sẽ được khai báo vào các file JSON tương ứng trong Grafana.

---

### 4.1. Vị trí trên Dashboard Developer (`dev-control` & `developer-docs`)

1. **Thanh điều hướng nhanh (Top Links)**:
   - Thêm nút liên kết: `[ 🔐 Cổng VPN WireGuard ]` dẫn thẳng tới `https://vpn.phungvip.io.vn`.
2. **Khối chào mừng & Nút thao tác nhanh (Greeting Quick Buttons)**:
   - Thêm nút màu tím: `<a href="https://vpn.phungvip.io.vn" target="_blank" class="dev-btn dev-btn-purple">🔐 Cổng VPN</a>` đặt cạnh nút `[ 🌐 Swagger UI ]` và `[ 📦 Reposilite ]`.
3. **Khối tài liệu hướng dẫn (Panel 1 - Markdown)**:
   - Thay thế hướng dẫn WARP cũ bằng quy trình 3 bước:
     - *Bước 1: Truy cập `https://vpn.phungvip.io.vn` đăng nhập tài khoản Keycloak.*
     - *Bước 2: Tải file `ridehub-dev.conf` hoặc quét mã QR nạp vào app WireGuard.*
     - *Bước 3: Bật VPN và kết nối vào Kafka (`10.10.0.1:9093`) & Redis (`10.10.0.1:6379`).*
4. **Bảng tra cứu Endpoints (Panel 2)**:
   - Cập nhật dải IP nội bộ WireGuard chuẩn:
     - Kafka SSL: `10.10.0.1:9093`
     - Redis Cache: `10.10.0.1:6379`
     - Consul KV: `10.10.0.1:8500` / `https://consul.phungvip.io.vn`
     - MySQLs: `10.10.0.2:3307 - 3310`

---

### 4.2. Vị trí trên Dashboard Ops/Admin (`ops-control` & `admin-docs`)

1. **Thanh Header Action Buttons**:
   - Thêm nút bấm:
     ```html
     <a href="https://vpn.phungvip.io.vn" target="_blank" rel="noopener noreferrer"
        style="display: inline-flex; align-items: center; gap: 6px; padding: 8px 12px; background: #261400; color: #ff9830; border: 1px solid #6b3f1c; border-radius: 5px; text-decoration: none; font-size: 12px; font-weight: 600;">
       🔐 WireGuard VPN Portal
     </a>
     ```
2. **Bảng Danh Mục 7 Web UIs Quản Trị Hệ Thống**:
   - Bổ sung dòng:
     `| WireGuard VPN Portal | https://vpn.phungvip.io.vn | SSO Admin / Dev | Cấp phát & quản lý kết nối WireGuard LAN |`

---

## Chương 5: Toàn Tập Tường Lửa UFW (Firewall Rules & Zero Trust)

### 5.1. Ma trận cổng & quyền truy cập (Port Matrix)

#### A. Trên VPS 1 (Infra Hub - IP Public: `103.x.y.1` | IP WireGuard: `10.10.0.1`)
| Cổng | Giao thức | Dịch vụ | Nguồn được phép truy cập (Source) | Hành động UFW |
|---|:---:|---|---|:---:|
| **51820** | UDP | WireGuard VPN | **Toàn Internet (`0.0.0.0/0`)** | `ALLOW` |
| **80, 443** | TCP | Cloudflare Ingress | **Cloudflare IP ranges / All** | `ALLOW` |
| **22** | TCP | SSH Server | **Chỉ Admin (`10.10.0.3`) qua `wg0`** | `ALLOW` (Stealth) |
| **9093** | TCP | Kafka SASL_SSL | **VPS 2 (`10.10.0.2`), Dev (`10.10.0.4+`)** | `ALLOW` |
| **6379** | TCP | Redis Cache | **VPS 2 (`10.10.0.2`), Dev (`10.10.0.4+`)** | `ALLOW` |
| **8500** | TCP | Consul API/UI | **VPS 2 (`10.10.0.2`), Admin (`10.10.0.3`)** | `ALLOW` |
| **8200** | TCP | Vault API | **VPS 2 (`10.10.0.2`), Admin (`10.10.0.3`)** | `ALLOW` |
| **51821** | TCP | wg-easy Web UI | **Chỉ Nginx nội bộ (`127.0.0.1`)** | `LOCAL` |

#### B. Trên VPS 2 (Microservices - IP Public: `159.x.y.2` | IP WireGuard: `10.10.0.2`)
| Cổng | Giao thức | Dịch vụ | Nguồn được phép truy cập (Source) | Hành động UFW |
|---|:---:|---|---|:---:|
| **80, 443** | TCP | Cloudflare Ingress | **Cloudflare IP ranges / All** | `ALLOW` |
| **22** | TCP | SSH Server | **Chỉ Admin (`10.10.0.3`) qua `wg0`** | `ALLOW` (Stealth) |
| **3307** | TCP | MySQL ms_route | **Admin (`10.10.0.3`), Dev Route** | `ALLOW` |
| **3308** | TCP | MySQL ms_user | **Admin (`10.10.0.3`), Dev User** | `ALLOW` |
| **3309** | TCP | MySQL ms_booking | **Admin (`10.10.0.3`), Dev Booking** | `ALLOW` |
| **3310** | TCP | MySQL ms_promotion| **Admin (`10.10.0.3`), Dev Promo** | `ALLOW` |
| **8080** | TCP | Spring Gateway | **Localhost / Nginx Ingress** | `LOCAL` |

---

### 5.2. Bộ lệnh thiết lập UFW trên VPS 1 (Infra Hub)

```bash
# 1. Reset UFW và đặt chính sách cơ sở
sudo ufw --force reset
sudo ufw default deny incoming
sudo ufw default allow outgoing

# 2. Mở cổng Ingress công khai
sudo ufw allow 51820/udp comment "WireGuard VPN Endpoint"
sudo ufw allow 80/tcp comment "HTTP Ingress"
sudo ufw allow 443/tcp comment "HTTPS Ingress"

# 3. Mở lưu lượng trên card mạng ảo wg0
sudo ufw allow in on wg0 comment "Allow WireGuard Subnet 10.10.0.0/24"

# 4. Stealth SSH: Chỉ mở riêng cho Admin (10.10.0.3)
sudo ufw allow from 10.10.0.3 to any port 22 proto tcp comment "Admin Stealth SSH"
sudo ufw deny from 10.10.0.0/24 to any port 22 proto tcp comment "Block Non-Admin SSH"

# 5. Phân quyền dịch vụ nội bộ (Kafka, Redis, Consul, Vault)
sudo ufw allow from 10.10.0.2 to any port 9093 proto tcp comment "VPS2 Kafka"
sudo ufw allow from 10.10.0.2 to any port 6379 proto tcp comment "VPS2 Redis"
sudo ufw allow from 10.10.0.2 to any port 8500 proto tcp comment "VPS2 Consul"
sudo ufw allow from 10.10.0.2 to any port 8200 proto tcp comment "VPS2 Vault"

# 6. Kích hoạt tường lửa
sudo ufw --force enable
sudo ufw status numbered
```

---

### 5.3. Bộ lệnh thiết lập UFW trên VPS 2 (Microservices)

```bash
# 1. Reset UFW và đặt chính sách cơ sở
sudo ufw --force reset
sudo ufw default deny incoming
sudo ufw default allow outgoing

# 2. Mở cổng Ingress công khai
sudo ufw allow 80/tcp comment "HTTP Ingress"
sudo ufw allow 443/tcp comment "HTTPS Ingress"

# 3. Mở lưu lượng trên card mạng ảo wg0
sudo ufw allow in on wg0 comment "Allow WireGuard Subnet 10.10.0.0/24"

# 4. Stealth SSH: Chỉ mở riêng cho Admin (10.10.0.3)
sudo ufw allow from 10.10.0.3 to any port 22 proto tcp comment "Admin Stealth SSH"
sudo ufw deny from 10.10.0.0/24 to any port 22 proto tcp comment "Block Non-Admin SSH"

# 5. Phân quyền truy cập MySQLs (3306 - 3310)
# Admin (10.10.0.3) toàn quyền vào tất cả các DB:
sudo ufw allow from 10.10.0.3 to any port 3306:3310 proto tcp comment "Admin All DBs"

# 6. Kích hoạt tường lửa
sudo ufw --force enable
sudo ufw status numbered
```

---

### 5.4. Cơ chế "Trói chân" an toàn cho Developer

Khi cấp tài khoản VPN cho Dev Nam (IP `10.10.0.4`, phụ trách `ms_booking`):

```bash
# Trên VPS 1: Cho Nam vào Kafka và Redis
sudo ufw allow from 10.10.0.4 to any port 9093 proto tcp comment "Dev Nam - Kafka"
sudo ufw allow from 10.10.0.4 to any port 6379 proto tcp comment "Dev Nam - Redis"

# Trên VPS 2: Cho Nam vào ĐÚNG MySQL của ms_booking (Port 3309)
sudo ufw allow from 10.10.0.4 to any port 3309 proto tcp comment "Dev Nam - Booking DB"

# KẾT QUẢ:
# - Nam CỐ TÌNH SSH CỔNG 22 ➡️ Bị DROP ngay lập tức
# - Nam CỐ TÌNH TRUY CẬP MySQL USER (3308) ➡️ Bị DROP
# - Nam CỐ TÌNH TRUY CẬP VAULT (8200) ➡️ Bị DROP
```

---

### 5.5. Xử lý bẫy nguy hiểm "Docker bypass UFW"

#### ⚠️ Vấn đề:
Khi khai báo `ports: - "3306:3306"` hoặc `ports: - "9093:9093"`, Docker tự động chèn rule vào `iptables` trước UFW, khiến cổng bị **mở toang ra ngoài Internet**, vượt mặt toàn bộ lệnh chặn của UFW!

#### ✅ Giải pháp:
Luôn chỉ định tường minh IP nội bộ `10.10.0.x` hoặc `127.0.0.1` trong `docker-compose.yml`:
```yaml
# Trên VPS 1:
services:
  kafka:
    ports:
      - "127.0.0.1:9093:9093"
      - "10.10.0.1:9093:9093"   # CHỈ LẮNG NGHE TRÊN WIREGUARD

  redis:
    ports:
      - "127.0.0.1:6379:6379"
      - "10.10.0.1:6379:6379"   # CHỈ LẮNG NGHE TRÊN WIREGUARD

# Trên VPS 2:
services:
  ms_booking_mysql:
    ports:
      - "127.0.0.1:3309:3306"
      - "10.10.0.2:3309:3306"   # CHỈ LẮNG NGHE TRÊN WIREGUARD
```

---

## Chương 6: Cheatsheet Vận Hành & Khắc Phục Sự Cố

### A. Cheatsheet Lệnh Nhanh

| Thao tác | WireGuard | UFW |
|---|---|---|
| **Xem trạng thái** | `sudo wg show` | `sudo ufw status numbered` |
| **Khởi động** | `sudo systemctl start wg-quick@wg0` | `sudo ufw enable` |
| **Dừng** | `sudo systemctl stop wg-quick@wg0` | `sudo ufw disable` |
| **Reload không ngắt mạng** | `sudo wg syncconf wg0 <(wg-quick strip wg0)` | `sudo ufw reload` |
| **Xóa 1 luật** | `sudo wg set wg0 peer <KEY> remove` | `sudo ufw delete <SO_THU_TU>` |

---

### B. Cứu hộ khẩn cấp khi bị khóa ngoài (Lockout Recovery)

Nếu bạn lỡ kích hoạt UFW mà chưa mở SSH:
1. Đăng nhập vào VPS bằng **VNC Web Console** (trên trang quản trị của nhà cung cấp VPS: Hetzner, DigitalOcean, Linode...).
2. Nhập `root` và mật khẩu VPS.
3. Chạy lệnh mở khẩn cấp:
   ```bash
   sudo ufw allow 22/tcp
   # Hoặc tắt tạm thời:
   sudo ufw disable
   ```
4. Kiểm tra lại kết nối WireGuard, sau đó cấu hình lại đúng IP Admin `10.10.0.3` rồi bật lại UFW.

