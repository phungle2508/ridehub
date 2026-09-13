# HẠ TẦNG: APACHE KAFKA (KRAFT EVENT STREAMING & ASYNC MESSAGING)

> **Phạm vi quản lý**: Xương sống giao tiếp bất đồng bộ (Event-Driven Architecture), Truyền phát sự kiện thời gian thực (Event Streaming), Phân định dữ liệu hợp đồng sự kiện (Avro Schemas), và Kết nối bảo mật đa máy chủ (Multi-VPS SSL 9093).

---

## 1. Bản chất & Cơ chế hoạt động của Kafka (KRaft)

Kafka là nền tảng xử lý luồng dữ liệu phân tán tốc độ cao (hàng trăm nghìn event/giây):
* **Kiến trúc KRaft (Không dùng Zookeeper)**: Quản trị metadata và bầu chọn leader trực tiếp thông qua giao thức đồng thuận Raft nội bộ, giúp hệ thống gọn nhẹ, khởi động nhanh và tiêu tốn ít RAM hơn.
* **Pub/Sub với Consumer Groups**: Cho phép nhiều bản sao của cùng một microservice chia sẻ việc xử lý sự kiện (Scale-out) mà không sợ bị trùng lặp message.
* **Durable Event Log & Replay**: Các sự kiện (như `BookingCreatedEvent`, `PaymentSuccessEvent`) được lưu trữ bền vững trên ổ đĩa. Nếu một service (như `ms_notification`) bị tắt bảo trì 2 tiếng, khi bật lại nó sẽ tự động đọc tiếp các event tồn đọng mà không bị mất dữ liệu.

---

## 2. Hiện trạng đã triển khai trong Repo RideHub (As-Is)

Kafka được triển khai tại `infra/vps-infra/docker-compose.yml` với cấu hình nâng cao chuẩn bị sẵn cho Multi-VPS:

1. **Dual Listeners (Hai cổng định tuyến thông minh)**:
   * **Listener nội bộ (`INTERNAL://kafka:9092`)**: Dành cho các container chạy chung Docker network trên cùng 1 VPS (tốc độ cao, không tốn tài nguyên mã hóa TLS).
   * **Listener công khai / bảo mật (`EXTERNAL://kafka.phungvip.io.vn:9093`)**: Cổng TLS/SSL bắt buộc dành cho các microservice đặt tại các VPS khác gọi về.
2. **Tự động sinh Chứng chỉ SSL (`central-server-config/kafka/kafka-init.sh`)**:
   * Tự động sinh CA nội bộ, Server Keystore, Truststore và cấp chứng chỉ với Subject Alternative Name (SAN) chứa FQDN của domain.
   * Script `renew-kafka-ssl.sh` hỗ trợ cấp lại chứng chỉ tức thì khi đổi tên miền.
3. **Quản trị trực quan qua Kafka UI**:
   * Truy cập qua subdomain riêng, bảo vệ bởi Cloudflare Zero Trust. Giúp theo dõi Consumer Lag, chi tiết các topic và nội dung từng message.
4. **Hợp đồng sự kiện chuẩn hóa (SSOT Contracts)**:
   * Tất cả cấu trúc Event (như `booking-event.avsc`, `payment-event.avsc`) được định nghĩa tập trung tại submodule **`infra/shared/ridehub-contract`** và đóng gói serializers trong **`infra/shared/ridehub-shared`**.

---

## 3. Những hạn chế & Tiềm năng chưa khai thác

| Tiềm năng chưa khai thác | Hiện trạng thực tế tại RideHub | Rủi ro / Điểm nghẽn |
|---|---|---|
| **Xác thực định danh Client (SASL / mTLS)** | Cổng SSL 9093 đang xác thực 1 chiều (Server TLS), client kết nối ẩn danh không cần user/pass. | Bất kỳ ai có mạng kết nối tới 9093 đều có thể đọc/ghi dữ liệu vào các topic nhạy cảm nếu không có SASL/SCRAM. |
| **Transactional Outbox Pattern** | Code ứng dụng đang thực hiện: Lưu vào MySQL $\rightarrow$ Gọi `kafkaTemplate.send()`. | **Mất tính nhất quán dữ liệu**: Nếu DB lưu thành công nhưng mạng chập chờn khiến Kafka gửi lỗi, vé đã đặt nhưng không có event nào bắn ra cho thanh toán/thông báo! |
| **Dead Letter Queue (DLQ) & Retry Policy** | Khi một Consumer xử lý lỗi (ví dụ bên thứ 3 lỗi), message có thể bị rơi vào vòng lặp retry vô tận hoặc bị drop mất. | Gây nghẽn partition (lag tăng cao) hoặc mất mát dữ liệu nghiệp vụ quan trọng. |
| **Schema Registry Runtime Enforcement** | Avro được compile tĩnh ở build-time qua Maven plugin, chưa có Schema Registry server kiểm soát runtime. | Nguy cơ producer đẩy dữ liệu phiên bản mới làm crash consumer phiên bản cũ nếu schema không tương thích lùi (backward compatibility). |
| **Kafka Multi-Node Cluster** | Đang chạy 1 Kafka Broker đơn lẻ trên VPS. | Điểm nghẽn chịu lỗi đơn điểm (Single Point of Failure - SPOF). |

---

## 4. Bảng kế hoạch lộ trình (Kafka Roadmap)

| Giai đoạn | Tính năng | Mục tiêu | Độ ưu tiên | Vị trí can thiệp |
|:---:|---|---|:---:|---|
| **P1** | **Chuẩn hóa DLQ & Exponential Retry** | Xây dựng cơ chế tự động đẩy message lỗi sang topic `.DLQ` sau 3 lần retry giãn cách, gửi cảnh báo về Telegram/Slack. | **P0 (Cần làm ngay)** | • `infra/shared/ridehub-shared` (Kafka Consumer Config) |
| **P2** | **Transactional Outbox Pattern (CDC)** | Lưu event vào bảng `outbox_events` trong cùng 1 Transaction MySQL, dùng Debezium hoặc Poller đẩy sang Kafka. | **P1 (Toàn vẹn dữ liệu)** | • `backend/ms_booking`, `backend/ms_payment` |
| **P3** | **Bật Xác thực SASL/SCRAM-SHA-512** | Mỗi microservice sở hữu 1 tài khoản Kafka riêng (`ms-booking-user`, `ms-payment-user`) kèm ACL chỉ đọc/ghi topic của mình. | **P1 (Bảo mật)** | • `central-server-config/kafka/`<br>• Spring Kafka properties |
| **P4** | **Triển khai Apicurio Schema Registry** | Kiểm soát tương thích schema động (Forward/Backward compatibility) trên hạ tầng. | **P2 (Chuẩn hóa)** | • `infra/vps-infra/docker-compose.yml` |
| **P5** | **Kafka Cluster 3 Nodes (KRaft Multi-VPS)** | Mở rộng thành cụm 3 node Kafka trải dài trên 3 VPS để đảm bảo hệ thống không bao giờ sập kể cả khi 1 VPS hỏng phần cứng. | **P3 (Sẵn sàng cao)** | • Kiến trúc N-VPS |

---

## 5. Chi tiết kỹ thuật & Hướng dẫn triển khai

### A. Triển khai Dead Letter Queue (DLQ) trong `ridehub-shared`
Cấu hình Spring Kafka DefaultErrorHandler với Backoff theo cấp số nhân:

```java
@Configuration
public class KafkaConsumerConfig {

    @Bean
    public CommonErrorHandler errorHandler(KafkaTemplate<Object, Object> template) {
        // Retry 3 lần, mỗi lần cách nhau 2 giây, 4 giây, 8 giây (nhân hệ số 2.0)
        ExponentialBackOffWithMaxRetries backOff = new ExponentialBackOffWithMaxRetries(3);
        backOff.setInitialInterval(2000L);
        backOff.setMultiplier(2.0);
        backOff.setMaxInterval(10000L);

        // Sau 3 lần thất bại, đẩy sang topic có hậu tố .DLQ
        DeadLetterPublishingRecoverer recoverer = new DeadLetterPublishingRecoverer(template,
            (consumerRecord, exception) -> new TopicPartition(consumerRecord.topic() + ".DLQ", consumerRecord.partition()));

        return new DefaultErrorHandler(recoverer, backOff);
    }
}
```

### B. Giải pháp Transactional Outbox Pattern cho `ms_booking`
Loại bỏ hoàn toàn lỗi bất đồng bộ dữ liệu:

```java
@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private OutboxEventRepository outboxRepository;

    public BookingDTO createBooking(BookingRequest request) {
        // 1. Lưu thông tin đặt vé vào bảng booking
        Booking booking = bookingRepository.save(toEntity(request));

        // 2. Lưu Event vào cùng Transaction trong bảng outbox_event của MySQL
        OutboxEvent event = new OutboxEvent();
        event.setAggregateType("BOOKING");
        event.setAggregateId(booking.getId().toString());
        event.setType("BookingCreatedEvent");
        event.setPayload(serializeToJson(booking));
        event.setStatus("PENDING");
        outboxRepository.save(event);

        // Transaction commit thành công cả 2 bảng cùng 1 lúc!
        return toDto(booking);
    }
}
```
*Sau đó, một background worker (hoặc Debezium CDC) sẽ đọc bảng `outbox_events` và bắn sang Kafka. Nếu có lỗi mạng, worker sẽ thử lại mà không làm mất dữ liệu!*

