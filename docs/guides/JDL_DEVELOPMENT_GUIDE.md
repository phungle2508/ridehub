# HƯỚNG DẪN PHÁT TRIỂN BACKEND TRÁNH BỊ GHI ĐÈ BỞI JDL (JHIPSTER)

> **Dành cho**: Các lập trình viên mới (Newbies) và AI Coding Assistants tham gia phát triển backend của hệ thống **RideHub**.
> **Mục tiêu tối thượng**: Hiểu rõ ranh giới giữa **Code sinh tự động từ JDL** và **Code nghiệp vụ tuỳ biến**, nắm vững kỹ thuật để code của bạn **không bao giờ bị mất hoặc bị ghi đè (overwrite)** khi nâng cấp hoặc sinh lại model JDL.

---

## 1. Bản chất kiến trúc Backend trong RideHub

Toàn bộ các microservice backend (`ms_booking`, `ms_user`, `ms_route`, `ms_promotion`, `gateway`) được khởi tạo từ tệp mô hình thực thể trung tâm:
👉 [**`docs/jdl/ridehub.jdl`**](../../docs/jdl/ridehub.jdl)

Khi chạy lệnh `jhipster jdl docs/jdl/ridehub.jdl`, JHipster sẽ đọc định nghĩa Entity, Relationship, DTO, Service, Liquibase changelogs và **tự động sinh ra toàn bộ khung code CRUD**.

> [!CAUTION]
> **CẢNH BÁO SỐNG CÒN (THE GOLDEN RULE)**:
> Nếu bạn sửa trực tiếp logic nghiệp vụ của mình vào các file do JDL sinh ra, lần tiếp theo khi dự án re-generate JDL (ví dụ: khi thêm một trường vào bảng database), **toàn bộ code của bạn trong các file đó sẽ bị JHipster ghi đè và biến mất hoàn toàn!**

---

## 2. Bản đồ vùng: Nguy hiểm (Danger Zone) vs An toàn (Safe Zone)

Trước khi viết bất kỳ dòng code nào, hãy đối chiếu với bảng sau:

### 🔴 VÙNG NGUY HIỂM (Danger Zone - JDL sở hữu: HẠN CHẾ SỬA TRỰC TIẾP)

| Thư mục / Tập tin | Vai trò | Hậu quả nếu sửa trực tiếp |
|---|---|---|
| `domain/*.java` | Entity model JPA | Bị ghi đè hoàn toàn khi sửa model trong JDL |
| `repository/*Repository.java` | Spring Data interfaces | JDL có thể xoá các method custom nếu không cẩn thận |
| `service/dto/*DTO.java` | Data transfer objects | Bị ghi đè cấu trúc thuộc tính |
| `service/mapper/*Mapper.java` | MapStruct mappers | Bị ghi đè cấu hình ánh xạ |
| `service/impl/*ServiceImpl.java` | CRUD Service mặc định | Bị ghi đè toàn bộ phương thức CRUD |
| `web/rest/*Resource.java` | REST Controller CRUD | Bị ghi đè các endpoints REST mặc định |
| `src/main/resources/config/liquibase/changelog/*_entity_*.xml` | Liquibase DDL khởi tạo | Tuyệt đối không sửa sau khi đã commit vào Git |
| `.jhipster/*.json` | Metadata cấu hình của JHipster | Do JHipster tự cập nhật, cấm sửa tay |

---

### 🟢 VÙNG AN TOÀN (Safe Zone - Bạn sở hữu: TỰ DO PHÁT TRIỂN)

Bất kỳ file nào **không nằm trong danh sách Entity của JDL** sẽ **VĨNH VIỄN AN TOÀN** khi re-generate:

1. **Custom Controllers**: Các file REST API nghiệp vụ đặc thù do bạn tạo mới:
   - `VNPayCallbackResource.java`, `PaymentWebhookResource.java`, `BookingCheckoutResource.java`
   - Hoặc gom vào package riêng: `web/rest/custom/*`
2. **Custom Services**: Các service xử lý luồng nghiệp vụ phức tạp:
   - `BookingPaymentWorkflowService.java`, `SeatHoldTimeoutService.java`, `VNPayService.java`
   - Hoặc gom vào package riêng: `service/custom/*`
3. **Custom Repositories**: Kỹ thuật mở rộng Spring Data JPA Custom Repository (`BookingRepositoryCustom.java`, `BookingRepositoryCustomImpl.java`).
4. **Custom Liquibase Changelogs**: Các migration script bổ sung (thêm index, trigger, view, sửa data) được đặt tên với timestamp mới.

---

## 3. Các kỹ thuật & Công cụ phòng tránh ghi đè

### Kỹ thuật 1: Áp dụng chuẩn "Side-by-Side" (Khuyên dùng số 1 ⭐⭐⭐⭐⭐)

Khi cần phát triển một tính năng mới (ví dụ: Thanh toán VNPay cho Booking):

❌ **CÁCH LÀM SAI (Nguy hiểm)**:
Mở `BookingResource.java` và `BookingServiceImpl.java` (do JDL sinh) rồi viết thêm logic thanh toán, xác thực OTP, gọi bên thứ ba vào đó. Lần sau sinh lại JDL -> Toàn bộ code bay màu!

✅ **CÁCH LÀM ĐÚNG (Side-by-Side Pattern)**:
Tách hẳn thành các class nghiệp vụ độc lập:
1. Tạo Controller riêng:
   ```text
   web/rest/PaymentWebhookResource.java  (hoặc web/rest/custom/BookingWorkflowResource.java)
   ```
2. Tạo Service riêng:
   ```text
   service/BookingPaymentService.java    (hoặc service/custom/BookingWorkflowServiceImpl.java)
   ```
3. Inject các dependency cần thiết:
   Trong `BookingPaymentService`, bạn hoàn toàn có thể inject `BookingRepository`, `TicketRepository` hoặc Kafka Producer để thao tác dữ liệu.
4. **Kết quả**: JHipster quét JDL sẽ không thấy tên các class này, nên **không bao giờ đụng đến hoặc ghi đè chúng**!

---

### Kỹ thuật 2: Sử dụng công cụ `.jhipsterignore` (Chính thức từ JHipster)

Trong trường hợp **bắt buộc phải sửa trực tiếp** vào file do JDL sinh (ví dụ: sửa logic trong `BookingServiceImpl.java` hoặc `BookingResource.java` mà không thể tách class):

1. Tạo file `.jhipsterignore` tại **thư mục gốc của microservice đó** (ngang hàng với `pom.xml`):
   ```
   backend/ms_booking/.jhipsterignore
   ```
2. Liệt kê đường dẫn các file bạn muốn JHipster **bỏ qua, không bao giờ ghi đè**:
   ```text
   # .jhipsterignore trong backend/ms_booking/
   src/main/java/com/ridehub/booking/service/impl/BookingServiceImpl.java
   src/main/java/com/ridehub/booking/web/rest/BookingResource.java
   ```
3. Khi bạn chạy lại lệnh `jhipster jdl docs/jdl/ridehub.jdl`, JHipster sẽ tự động phát hiện file `.jhipsterignore` và giữ nguyên 100% nội dung các file đã khai báo!

---

### Kỹ thuật 3: Sử dụng JHipster Needle (`// jhipster-needle-...`)

Khi cần chèn thêm cấu hình vào các file khung của hệ thống (như Spring Security, Liquibase master changelog):
* Mở file cấu hình, tìm comment có dạng:
  ```java
  // jhipster-needle-add-entity-to-cache - JHipster will add entity to cache here
  ```
  hoặc trong Liquibase `master.xml`:
  ```xml
  <!-- jhipster-needle-liquibase-add-changelog - JHipster will add changelogs here -->
  ```
* Chèn nội dung của bạn ngay bên dưới dòng comment needle đó.
* JHipster khi generate lại sẽ tự động nhận biết vị trí needle và **không xoá** những gì bạn đã chèn.

---

### Kỹ thuật 4: Kỹ thuật Liquibase Migration an toàn

Tuyệt đối **không sửa** các file changelog entity cũ đã được migrate trên database:
* CẤM sửa: `src/main/resources/config/liquibase/changelog/20260309100000_added_entity_Booking.xml`
* Để thêm cột, đổi kiểu dữ liệu hoặc tạo index mới:
  1. Tạo file changelog mới với timestamp hiện tại:
     `src/main/resources/config/liquibase/changelog/20260910120000_add_payment_reference_to_booking.xml`
  2. Khai báo include file mới vào `master.xml` tại vị trí comment needle:
     ```xml
     <include file="config/liquibase/changelog/20260910120000_add_payment_reference_to_booking.xml" relativeToChangelogFile="false"/>
     ```

---

## 4. Quy trình chuẩn khi cần cập nhật Schema / Model Database

Khi có yêu cầu nghiệp vụ cần thêm trường dữ liệu hoặc tạo bảng mới, hãy thực hiện đúng 5 bước sau:

```
[Bước 1: Sửa JDL] ──► [Bước 2: Tạo Git Branch] ──► [Bước 3: Check .jhipsterignore]
                                                              │
[Bước 5: Git Diff & Review] ◄── [Bước 4: Sinh lại JDL] ◄──────┘
```

1. **Bước 1**: Mở [**`docs/jdl/ridehub.jdl`**](../../docs/jdl/ridehub.jdl), thêm thuộc tính hoặc entity mới theo chuẩn cú pháp JDL.
2. **Bước 2**: Tạo một git branch mới trước khi generate để đảm bảo an toàn:
   ```bash
   git checkout -b chore/update-booking-schema
   ```
3. **Bước 3**: Kiểm tra file `.jhipsterignore` của các service liên quan để chắc chắn các file custom đã được bảo vệ.
4. **Bước 4**: Chạy lệnh sinh lại code (tại thư mục service hoặc từ root):
   ```bash
   # Tại thư mục microservice cần cập nhật (ví dụ ms_booking):
   cd backend/ms_booking
   jhipster jdl ../../docs/jdl/ridehub.jdl --incremental-changelog
   ```
5. **Bước 5**: Chạy `git diff` hoặc dùng Source Control trên VS Code / IntelliJ để review lại từng thay đổi. Đảm bảo không có dòng code nghiệp vụ nào bị vô tình ghi đè trước khi merge vào nhánh chính!

---

## 5. Bảng tóm tắt Checklist cho Developer mới

- [ ] Tôi đã hiểu `docs/jdl/ridehub.jdl` là nguồn sinh mã CRUD tự động.
- [ ] Tôi không viết logic phức tạp vào `*ServiceImpl.java` hoặc `*Resource.java` do JDL sinh.
- [ ] Tôi đã tạo class Service/Resource riêng (`Side-by-Side`) cho nghiệp vụ đặc thù của mình.
- [ ] Nếu buộc phải sửa file JDL sinh, tôi đã thêm đường dẫn file đó vào `.jhipsterignore`.
- [ ] Tôi không sửa trực tiếp Liquibase changelog cũ mà tạo file changelog mới.
- [ ] Tôi luôn kiểm tra `git diff` cẩn thận sau khi chạy các lệnh liên quan đến JHipster / JDL.

> 🛠️ **Kế hoạch tự động hoá quy trình Revert & Sync**: Xem chi tiết bản thiết kế Pipeline tự động hoá tại [**`docs/script/README.md`**](../script/README.md).
