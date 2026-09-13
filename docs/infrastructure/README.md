# BẢN ĐỒ HẠ TẦNG & LỘ TRÌNH PHÁT TRIỂN (RIDEHUB INFRASTRUCTURE ROADMAP)

> **Mục đích**: Tài liệu hóa toàn diện hệ thống hạ tầng phân tán (Multi-VPS Infrastructure) của RideHub. Mỗi tài liệu con phân tích sâu: **Bản chất công nghệ**, **Hiện trạng đã cài đặt trong repo**, **Các tính năng tiềm năng chưa khai thác**, **Bảng kế hoạch lộ trình (Roadmap)** và **Hướng dẫn kỹ thuật thực chiến**.

---

## 1. Sơ đồ kiến trúc hạ tầng tổng quan

```
                                  INTERNET (Người dùng & Thiết bị)
                                                │
                                    Cloudflare Edge (WAF / SSL)
                                                │ (Zero Trust Ingress)
                                                ▼
                                    cloudflared (QUIC Tunnel)
                                                │
                                                ▼
                                        Nginx (Port 80/443)
      ┌──────────────┬──────────────┬───────────┴──┬──────────────┬──────────────┐
      ▼              ▼              ▼              ▼              ▼              ▼
  [Keycloak]      [Consul]       [Vault]       [Kafka UI]   [RedisInsight]   [Grafana]
 (Identity/SSO)  (Discovery/KV) (Secrets/PII) (Kafka Admin)   (Redis Admin)   (Dashboard)
      │              ▲              ▲              │              │              ▲
      ▼              │              │              ▼              ▼              │
[Microservices: Gateway, ms_user, ms_booking, ms_route, ms_promotion, ms_payment]
      │                             │              │              │              │
      ▼                             ▼              ▼              ▼              │
 [Per-Service DB]              [AppRole]     [Kafka KRaft]   [Redis Cache]   [Promtail]
  (MySQL 9.x)                (Dynamic Cred) (Event Streams) (Lock/Cache)    (Log Shipper)
                                                                                 │
                                                                                 ▼
                                                                          [Loki/Prometheus]
```

---

## 2. Danh mục tài liệu chi tiết từng thành phần Hạ tầng

Mỗi file tài liệu bên dưới đại diện cho 1 thành phần hạ tầng độc lập:

| STT | Thành phần Hạ tầng | Tài liệu chi tiết | Trọng tâm phân tích & Tiềm năng tương lai |
|:---:|---|---|---|
| **01** | **HashiCorp Vault** | [vault.md](vault.md) | Quản lý Secrets tĩnh (KV v2), Auth Method OIDC/AppRole, Transit Encryption (PII), Dynamic DB Credential, Auto-Unseal. |
| **02** | **HashiCorp Consul** | [consul.md](consul.md) | Service Discovery định tuyến FQDN HTTPS, Health Check, Consul KV vs Vault KV, Consul ACL Tokens, Watcher tự đồng bộ. |
| **03** | **Keycloak IAM** | [keycloak.md](keycloak.md) | Chuẩn OIDC/OAuth2 SSO, Realm `jhipster`, Client Credentials (`web_app`, `internal`), RBAC Roles, MFA, Token Exchange. |
| **04** | **Apache Kafka (KRaft)** | [kafka.md](kafka.md) | Event Streaming không cần Zookeeper, Dual Listener (Nội bộ & Multi-VPS SSL 9093), Kafka ACLs, Schema Registry Avro (SSOT). |
| **05** | **Redis** | [redis.md](redis.md) | Cache dữ liệu chuyến xe/tuyến đường, Redisson Distributed Lock (chống giữ ghế đè `ms_booking`), Rate Limiting API Gateway. |
| **06** | **MySQL (Per-Service)** | [mysql.md](mysql.md) | Triết lý Database-per-Service, phân lập Schema/Instance, Liquibase Migration độc lập, HikariCP Connection Pool, Chiến lược Backup. |
| **07** | **Elasticsearch** | [elasticsearch.md](elasticsearch.md) | Tìm kiếm hành trình/tuyến xe theo địa lý (Geo-spatial & Full-text search), đồng bộ dữ liệu CDC qua Kafka/Logstash, Elasticsearch Cluster. |
| **08** | **Observability** | [observability.md](observability.md) | Prometheus (Metric scrapers), Grafana (Ops Control Dashboards), Loki & Promtail (Log aggregation), Alertmanager (Cảnh báo sự cố Telegram). |
| **09** | **Network & Ingress** | [network_ingress.md](network_ingress.md) | Cloudflare Tunnel (QUIC Ingress), Nginx Reverse Proxy, WireGuard Mesh VPN (Bảo mật Layer 4 kết nối giữa các VPS), UFW Firewall. |

---

## 3. Nguyên tắc vận hành cốt lõi (Core Principles)

Mọi thành phần hạ tầng trong hệ thống RideHub bắt buộc phải tuân thủ 3 nguyên tắc đã quy định tại `AGENTS.md`:

1. **Multi-VPS First**: Không hardcode `localhost` hoặc IP nội bộ máy chủ; mọi service đều phải sẵn sàng chạy phân tán trên nhiều VPS.
2. **Database per Service**: Không gộp database, không join bảng chéo giữa các microservice.
3. **Zero Fallback & Strict Fail-Fast**: Không dùng cú pháp fallback cascaded `${A:-${B}}`; mọi biến credentials bắt buộc khai báo `${VAR:?VAR is required}` để dừng ngay lập tức nếu thiếu cấu hình.

