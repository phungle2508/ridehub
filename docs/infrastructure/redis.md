# HẠ TẦNG: REDIS (DISTRIBUTED CACHING, LOCKING & RATE LIMITING)

> **Phạm vi quản lý**: Bộ nhớ đệm tốc độ cao (In-Memory Cache), Khóa phân tán chống tranh chấp ghế (Redisson Distributed Lock), Giới hạn tần suất request (Rate Limiting tại Gateway), và Lưu trữ dữ liệu tạm có thời hạn (OTP / Session TTL).

---

## 1. Bản chất & Cơ chế hoạt động của Redis

Redis là cơ sở dữ liệu in-memory cấu trúc key-value với độ trễ tính bằng micro-giây (< 1ms):
* **Cơ chế Single-Threaded Event Loop**: Xử lý các phép toán nguyên tử (Atomic Operations) một cách an toàn tuyệt đối, không lo ngại Race Condition.
* **Hỗ trợ TTL tự động (Time-To-Live)**: Tự động giải phóng bộ nhớ khi dữ liệu hết hạn (rất thích hợp cho mã xác thực OTP 5 phút, giữ ghế xe 10 phút, hoặc cache kết quả tìm chuyến xe 1 phút).
* **Khóa phân tán (Distributed Locks - Redlock / Redisson)**: Đảm bảo trong cụm nhiều microservice hoặc nhiều thread cùng chạy, tại một thời điểm chỉ có DUY NHẤT một người dùng được phép thao tác trên một tài nguyên cụ thể (ví dụ: ghế số 12 trên chuyến xe chuyến 20:00).

---

## 2. Hiện trạng đã triển khai trong Repo RideHub (As-Is)

Hiện tại, Redis được triển khai kết hợp cả ở cụm hạ tầng trung tâm và các container cục bộ của từng microservice:

1. **Redis Server trung tâm (`vps-infra/docker-compose.yml`)**:
   - Chạy image `redis:7.4-alpine` tại cổng 6379 với bảo mật mật khẩu `${REDIS_PASSWORD}`.
2. **Giao diện quản trị RedisInsight**:
   - Tích hợp giao diện trực quan RedisInsight kết nối vào Redis, cho phép kiểm tra keyspace, memory consumption, phân tích lệnh chậm (slowlog) và quản lý key theo regex.
3. **Bộ nhớ đệm từng Microservice**:
   - File cấu hình `docker-compose.yml` của microservice định nghĩa các biến kết nối:
     * `JHIPSTER_CACHE_REDIS_SERVER=redis://ms_user-redis:6379`
     * Spring Cache abstraction `@Cacheable` cho các query thông tin danh mục, thông tin tài xế ít biến động.

---

## 3. Những hạn chế & Tiềm năng chưa khai thác

| Tiềm năng chưa khai thác | Hiện trạng thực tế tại RideHub | Rủi ro / Điểm nghẽn |
|---|---|---|
| **Chống đặt trùng ghế (Double Booking)** | Chưa có khóa phân tán Redisson trên mã ghế; đang dựa vào logic kiểm tra trạng thái trong MySQL transaction. | Khi hàng ngàn hành khách cùng mở bán vé Tết và click chọn cùng 1 ghế trong cùng 1 mili-giây, cơ chế DB lock có thể bị nghẽn deadlock hoặc sót race-condition. |
| **API Rate Limiting tại Gateway** | Chưa bật RequestRateLimiter trên Spring Cloud Gateway. | Nguy cơ bị bot cào dữ liệu tuyến đường hoặc spam API thanh toán làm quá tải các microservice phía sau. |
| **Chiến lược làm tươi Cache (Cache Eviction)** | Dữ liệu chuyến xe (`ms_route`) đang dùng TTL cố định thay vì cơ chế xóa cache theo sự kiện (Event-Driven Invalidation). | Người dùng có thể thấy thông tin chuyến xe cũ hoặc giá vé chưa cập nhật cho đến khi hết hạn TTL. |
| **High Availability (Redis Sentinel / Cluster)** | Đang chạy Redis Standalone (1 node đơn lẻ). | Nếu container Redis bị đầy RAM hoặc khởi động lại, toàn bộ request phải chọc thẳng xuống MySQL làm tải DB tăng vọt (Cache Stampede). |

---

## 4. Bảng kế hoạch lộ trình (Redis Roadmap)

| Giai đoạn | Tính năng | Mục tiêu | Độ ưu tiên | Vị trí can thiệp |
|:---:|---|---|:---:|---|
| **P1** | **Redisson Distributed Lock (Giữ chỗ ghế)** | Khóa nguyên tử mã ghế trong 10 phút; đảm bảo tuyệt đối không bao giờ có 2 người mua cùng 1 ghế. | **P0 (Nghiệp vụ sống còn)** | • `backend/ms_booking` |
| **P2** | **Gateway Redis Rate Limiting** | Giới hạn mỗi IP/User tối đa 20 request/giây; chặn bot dò quét vé và tấn công brute-force OTP. | **P1 (Bảo vệ hệ thống)** | • `backend/gateway` (Spring Cloud Gateway) |
| **P3** | **Event-Driven Cache Eviction với Kafka** | Khi Admin sửa lộ trình hoặc giá vé ở `ms_route`, Kafka bắn event sang các service để tự động xóa key Redis tương ứng. | **P1 (Độ chính xác dữ liệu)** | • `backend/ms_route`, `ridehub-shared` |
| **P4** | **Lưu trữ phiên OTP tập trung** | Đưa toàn bộ mã OTP SMS xác thực đăng nhập tài xế/khách hàng vào Redis với TTL tự động hủy sau 3 phút. | **P2 (Chuẩn hóa)** | • `backend/ms_user` |
| **P5** | **Redis Sentinel (Tự động chuyển tiếp lỗi)** | Thiết lập 1 Master + 1 Replica + 3 Sentinel để tự động chuyển tiếp Master sang Replica trong 3 giây nếu node chính lỗi. | **P3 (Sẵn sàng cao)** | • `vps-infra/docker-compose.yml` |

---

## 5. Chi tiết kỹ thuật & Hướng dẫn triển khai

### A. Cơ chế Redisson Distributed Lock cho giữ ghế (`ms_booking`)
Tránh triệt để bài toán tranh chấp ghế trong ngày cao điểm:

```java
@Service
public class SeatHoldService {

    @Autowired
    private RedissonClient redissonClient;

    public boolean holdSeat(Long tripId, String seatNumber, String userId) {
        String lockKey = String.format("lock:trip:%d:seat:%s", tripId, seatNumber);
        RLock lock = redissonClient.getLock(lockKey);

        try {
            // Thử lấy lock trong 1 giây. Nếu lấy được, giữ khóa trong 10 phút (TTL 600s)
            boolean isLocked = lock.tryLock(1, 600, TimeUnit.SECONDS);
            if (!isLocked) {
                throw new SeatAlreadyHeldException("Ghế này đang có người khác giữ chỗ!");
            }

            // Ghi nhận thông tin người giữ chỗ vào Redis
            String holdDataKey = String.format("data:trip:%d:seat:%s", tripId, seatNumber);
            redissonClient.getBucket(holdDataKey).set(userId, 600, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public void releaseSeat(Long tripId, String seatNumber) {
        String lockKey = String.format("lock:trip:%d:seat:%s", tripId, seatNumber);
        RLock lock = redissonClient.getLock(lockKey);
        if (lock.isHeldByCurrentThread()) {
            lock.unlock();
        }
    }
}
```

### B. Cấu hình Rate Limiter tại Spring Cloud Gateway
Cấu hình trong `gateway/src/main/resources/config/application.yml`:

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: ms_booking_route
          uri: lb://ms-booking
          predicates:
            - Path=/api/bookings/**
          filters:
            - name: RequestRateLimiter
              args:
                redis-rate-limiter.replenishRate: 10   # Cho phép trung bình 10 requests/giây
                redis-rate-limiter.burstCapacity: 20   # Tối đa 20 requests khi có đột biến
                key-resolver: "#{@userKeyResolver}"    # Phân loại giới hạn theo User ID hoặc IP
```

