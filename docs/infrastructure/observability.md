# HẠ TẦNG: OBSERVABILITY (PROMETHEUS, GRAFANA, LOKI & PROMTAIL)

> **Phạm vi quản lý**: Giám sát chỉ số hệ thống (Metrics với Prometheus), Bảng điều khiển tập trung (Grafana Dashboards), Thu thập & Tra cứu nhật ký (Log Aggregation với Loki & Promtail), và Cảnh báo tức thời (Alertmanager tới Telegram/Slack).

---

## 1. Bản chất & Cơ chế hoạt động của Cụm Giám sát

Trong hệ thống phân tán Multi-VPS, không thể dùng SSH vào từng máy chủ để gõ `docker logs`:
* **Metrics (Prometheus)**: Định kỳ (mỗi 15 giây) kéo các chỉ số định lượng từ endpoint `/management/prometheus` của Spring Boot (CPU, RAM, HikariCP Connection Pool, HTTP Request Latency p95/p99, JVM Garbage Collection).
* **Logs (Loki & Promtail)**: Promtail gắn trực tiếp vào Docker socket (`/var/run/docker.sock`), tự động tóm tất cả dòng log từ mọi container và đẩy về kho lưu trữ tập trung Loki. Cho phép tìm kiếm log bằng ngôn ngữ LogQL tương tự PromQL.
* **Dashboards (Grafana)**: Nơi hiển thị trực quan các biểu đồ sức khỏe hạ tầng (Ops Control) và biểu đồ chỉ số nghiệp vụ (Business KPIs).
* **Alerting (Alertmanager)**: Tự động phát hiện bất thường (ví dụ: Tỷ lệ lỗi 5xx vượt quá 2% hoặc DB pool bị nghẽn) và gửi thông báo khẩn cấp về Telegram.

---

## 2. Hiện trạng đã triển khai trong Repo RideHub (As-Is)

Cụm giám sát được cấu hình tại `infra/vps-infra/central-server-config/observability/`:

1. **Prometheus Scraper (`prometheus.yml`)**:
   * Đã cấu hình các job quét metrics từ Spring Boot Gateway, Consul, Keycloak, Kafka Exporter và Node Exporter của máy chủ VPS.
2. **Loki & Promtail (`loki-config.yaml`, `promtail-config.yaml`)**:
   * Promtail tự động gán nhãn (`labels: container_name, compose_service`) cho từng dòng log để dễ dàng lọc trên Grafana Explore.
3. **Grafana Provisioning**:
   * Tự động nạp sẵn Datasources (Prometheus, Loki) khi khởi động container.
   * Cung cấp trang Dashboard quản trị Ops Control.

---

## 3. Những hạn chế & Tiềm năng chưa khai thác

| Tiềm năng chưa khai thác | Hiện trạng thực tế tại RideHub | Rủi ro / Điểm nghẽn |
|---|---|---|
| **Truy vết phân tán (Distributed Tracing)** | Chưa có OpenTelemetry / Jaeger / Tempo để gắn mã `traceId` và `spanId` xuyên suốt các service. | Khi một thao tác đặt vé bị chậm 5 giây, kỹ sư rất khó biết chính xác độ trễ nằm ở Gateway, `ms_booking`, gọi Feign sang `ms_user` hay do gửi Kafka. |
| **Cảnh báo tức thời qua Telegram / Slack** | Prometheus và Grafana đã thu thập chỉ số nhưng chưa tích hợp Webhook gửi tin nhắn khi có sự cố. | Đội ngũ vận hành chỉ biết service sập khi có phản ánh từ người dùng. |
| **Dashboard nghiệp vụ (Business KPI)** | Dashboards hiện tại chủ yếu theo dõi hạ tầng phần cứng (CPU, RAM, Disk). | Thiếu các chỉ số kinh doanh quan trọng: Doanh thu theo giờ, số vé bán thành công, tỷ lệ lỗi thanh toán SePay/VNPay. |
| **Chính sách dọn dẹp Log (Log Retention)** | Loki chưa giới hạn ngày lưu trữ log cụ thể. | Sau vài tháng chạy thực tế, dung lượng ổ cứng VPS có thể bị đầy do file log phình to. |

---

## 4. Bảng kế hoạch lộ trình (Observability Roadmap)

| Giai đoạn | Tính năng | Mục tiêu | Độ ưu tiên | Vị trí can thiệp |
|:---:|---|---|:---:|---|
| **P1** | **Cảnh báo Telegram khi Service Sập** | Tích hợp Alertmanager với Telegram Bot; báo ngay khi bất kỳ microservice nào rơi vào trạng thái Down quá 30 giây. | **P0 (Cần làm ngay)** | • `observability/prometheus.yml`<br>• Alertmanager config |
| **P2** | **OpenTelemetry Distributed Tracing** | Nhúng Micrometer Tracing vào `ridehub-shared`; theo dõi vòng đời 1 request xuyên suốt qua các VPS. | **P1 (Tìm lỗi cực nhanh)** | • `infra/shared/ridehub-shared`<br>• Bật Grafana Tempo |
| **P3** | **Dashboard Nghiệp vụ Bán vé (Business Dashboard)** | Xây dựng biểu đồ: Số lượng vé đặt/hủy theo thời gian thực, doanh số theo nhà xe, tỷ lệ giao dịch cổng thanh toán. | **P1 (Kinh doanh & Vận hành)** | • Grafana Dashboards |
| **P4** | **Loki Log Retention Policy (Giữ log 14 ngày)** | Cấu hình Loki tự động dọn dẹp log cũ hơn 14 ngày để bảo vệ ổ cứng SSD của VPS. | **P2 (Duy trì hệ thống)** | • `observability/loki-config.yaml` |
| **P5** | **Kafka Consumer Lag Alert** | Báo động khi số lượng message tồn đọng trong partition của Kafka vượt quá 1000 message (cảnh báo nghẽn luồng xử lý). | **P2 (Độ tin cậy)** | • Prometheus Alert Rules |

---

## 5. Chi tiết kỹ thuật & Hướng dẫn triển khai

### A. Cấu hình Cảnh báo Alertmanager gửi tin nhắn về Telegram
Thêm file cấu hình `alertmanager.yml`:

```yaml
global:
  resolve_timeout: 5m

route:
  group_by: ['alertname', 'job']
  group_wait: 30s
  group_interval: 5m
  repeat_interval: 3h
  receiver: 'telegram-ops-channel'

receivers:
  - name: 'telegram-ops-channel'
    telegram_configs:
      - bot_token: "${TELEGRAM_BOT_TOKEN}"
        chat_id: ${TELEGRAM_CHAT_ID}
        send_resolved: true
        message: |
          🚨 *RIDEHUB ALERT: {{ .Status | toUpper }}*
          *Alert:* {{ .CommonLabels.alertname }}
          *Severity:* {{ .CommonLabels.severity }}
          *Service:* {{ .CommonAnnotations.summary }}
          *Description:* {{ .CommonAnnotations.description }}
```

### B. Quy tắc cảnh báo Microservice sập (`alert.rules.yml`)
Khai báo trong Prometheus:

```yaml
groups:
  - name: ridehub-services
    rules:
      - alert: ServiceDown
        expr: up{job="microservices"} == 0
        for: 30s
        labels:
          severity: critical
        annotations:
          summary: "Microservice {{ $labels.instance }} bị mất kết nối!"
          description: "Service đã ngừng phản hồi health check trong hơn 30 giây."

      - alert: HikariPoolExhausted
        expr: hikaricp_connections_pending > 5
        for: 1m
        labels:
          severity: warning
        annotations:
          summary: "Cảnh báo nghẽn kết nối Database tại {{ $labels.instance }}"
          description: "Đang có hơn 5 request phải xếp hàng chờ mượn kết nối MySQL."
```

