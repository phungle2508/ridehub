# RIDEHUB ARCHITECTURE RULES: SUBMODULE INDEPENDENCE, JDL CODE HYGIENE & MULTI-VPS

> **Dành cho**: Tất cả AI Coding Assistants (Antigravity, Cursor, Copilot, Claude, v.v.) và Developers tham gia phát triển, bảo trì hệ thống **RideHub**.
> **Mục tiêu**: Đảm bảo toàn bộ hệ thống luôn tuân thủ nghiêm ngặt tính **độc lập tuyệt đối của các Submodules**, bảo vệ **mã nguồn tự sinh từ JDL (JHipster)**, và sẵn sàng mở rộng theo **triết lý Multi-VPS (Phân tán nhiều máy chủ)**.

---

## 1. Tuyên ngôn kiến trúc (Core Philosophy)

1. **Submodule Autonomy (Độc lập Submodule)**:
   Mỗi Git Submodule trong RideHub là một thực thể độc lập có vòng đời riêng, Git repository riêng, cơ sở dữ liệu riêng, CI/CD riêng và có thể build/test/run hoàn toàn độc lập mà không cần sự tồn tại của các submodule khác trên cùng một ổ đĩa.
2. **JDL-First & Code Isolation (Tôn trọng mã sinh tự động từ JDL)**:
   Code nền tảng backend được sinh tự động từ `docs/jdl/ridehub.jdl`. Cần phân định ranh giới tuyệt đối giữa mã sinh tự động (Auto-generated CRUD) và mã nghiệp vụ tuỳ biến (Custom Business Logic) để tránh bị ghi đè (overwrite) khi re-generate JDL.
3. **Multi-VPS First (Triết lý Đa máy chủ)**:
   Hệ thống không giả định tất cả microservices và hạ tầng cùng nằm trên một máy chủ vật lý hay cùng một Docker bridge network. Bất kỳ service nào cũng có thể được đặt tại VPS 1, VPS 2, VPS 3... hoặc trải dài trên các cụm đám mây khác nhau. Mọi giao tiếp liên service phải đi qua mạng có thể định tuyến (Routable Network: FQDN, Cloudflare Ingress, Service Mesh, hoặc Overlay VPN).

---

## 2. Các quy tắc bất di bất dịch (Immutable Rules)

### Rule 1: Độc lập mã nguồn và quy trình Build (Zero Source Coupling)
- **CẤM**: Tuyệt đối không sử dụng đường dẫn tương đối (relative path như `../../backend/ms_user`) để import code, đọc file, copy schema, hoặc chia sẻ mã nguồn giữa các submodule.
- **CẤM**: Submodule con không được phụ thuộc vào `backend/pom.xml` ở root repository. Mọi `pom.xml` của microservice phải kế thừa trực tiếp từ `spring-boot-starter-parent` với `<relativePath/>`.
- **BẮT BUỘC**: Mỗi submodule phải tự build được độc lập bằng `./mvnw clean verify` hoặc `./mvnw compile` mà không yêu cầu submodule lân cận phải có mặt.

### Rule 2: Cơ sở dữ liệu độc lập (Database per Service)
- **CẤM**: Tuyệt đối không cho phép Service A truy cập trực tiếp vào cơ sở dữ liệu của Service B (kể cả chỉ đọc - Read-only).
- **CẤM**: Không tạo foreign key hoặc liên kết database ngang hàng giữa các microservices.
- **BẮT BUỘC**: Mỗi microservice sở hữu một database riêng biệt (riêng instance MySQL hoặc riêng database schema độc lập), có migration script riêng (Liquibase changelog nằm trọn vẹn trong repository của service đó).
- **Giao tiếp dữ liệu**: Muốn lấy dữ liệu của service khác, bắt buộc phải thông qua **REST API (OpenAPI/Feign)** hoặc **Kafka Events (AsyncAPI/Avro)**.

### Rule 3: Giao tiếp qua Contract & Phân phối Thư viện chuẩn (SSOT & Remote Artifacts)
- **Nguồn sự thật duy nhất (SSOT)**:
  Mọi định nghĩa Schema/Contract giao tiếp (OpenAPI YAML, Avro AVSC, AsyncAPI) chỉ được lưu tại submodule **`infra/shared/ridehub-contract`**.
- **Thư viện dùng chung (`ridehub-shared`)**:
  Code client (Feign client sinh tự động, Kafka serializers, Security interceptor) được đóng gói trong **`infra/shared/ridehub-shared`**.
- **Phân phối qua Package Registry**:
  Các microservice **chỉ được phép phụ thuộc vào `ridehub-shared` thông qua Maven Repository (Reposilite tại `https://repo.phungvip.io.vn`)**, tuyệt đối không link source code cục bộ vào production build.

### Rule 4: Quản lý Code Sinh Tự Động từ JDL (JHipster Code Hygiene)
Hầu hết các microservice trong `backend/*` được khởi tạo tự động từ file bản mẫu **`docs/jdl/ridehub.jdl`**. Để không làm mất mã nguồn khi re-generate hoặc nâng cấp model:

#### A. Phân loại thư mục & Giới hạn sửa đổi:
| Thư mục / File | Nguồn gốc | Mức độ can thiệp | Hướng dẫn xử lý |
|---|:---:|:---:|---|
| `domain/*` (Entity models) | JDL sinh | 🔴 **HẠN CHẾ SỬA** | Cần thêm/bớt trường: sửa trực tiếp trong `docs/jdl/ridehub.jdl` rồi sinh lại. |
| `repository/*Repository.java` | JDL sinh | 🟡 **CÓ ĐIỀU KIỆN** | Chỉ thêm các method `@Query` mới, không xoá hoặc đổi method mặc định. |
| `service/dto/*` & `service/mapper/*` | JDL sinh | 🔴 **HẠN CHẾ SỬA** | Sinh tự động theo MapStruct và DTO từ JDL. |
| `service/impl/*ServiceImpl.java` | JDL sinh | 🟡 **CÓ ĐIỀU KIỆN** | Chỉ chứa logic CRUD chuẩn. Với business logic phức tạp: **TÁCH SERVICE RIÊNG**. |
| `web/rest/*Resource.java` | JDL sinh | 🟡 **CÓ ĐIỀU KIỆN** | Chỉ chứa CRUD endpoints chuẩn. API tuỳ chỉnh: **TÁCH RESOURCE RIÊNG**. |
| `src/main/resources/config/liquibase/changelog/*_entity_*.xml` | JDL sinh | ⛔ **CẤM SỬA TRỰC TIẾP** | Không sửa changelog cũ của entity đã chạy. Thêm migration mới bằng file độc lập. |
| `.jhipster/*.json` | JDL sinh | ⛔ **CẤM SỬA TAY** | Metadata do JHipster tự cập nhật khi parse JDL. |
| **Custom Controllers / Services** | Tự viết | 🟢 **KHUYẾN KHÍCH** | `web/rest/custom/*`, `service/custom/*`, hoặc các service nghiệp vụ độc lập. |

#### B. Các công cụ & Kỹ thuật hỗ trợ bảo vệ code custom:
1. **Sử dụng file `.jhipsterignore` (Công cụ chính thức của JHipster)**:
   - Đặt file `.jhipsterignore` tại thư mục gốc của từng microservice (vd: `backend/ms_booking/.jhipsterignore`).
   - Khai báo các đường dẫn file tùy chỉnh vào đây. Khi chạy lại `jhipster jdl`, JHipster sẽ **bỏ qua hoàn toàn, không bao giờ ghi đè** các file này:
     ```text
     # Ví dụ trong backend/ms_booking/.jhipsterignore
     src/main/java/com/ridehub/booking/service/impl/BookingServiceImpl.java
     src/main/java/com/ridehub/booking/web/rest/BookingResource.java
     ```
2. **Kỹ thuật Side-by-Side (Custom Resource & Service Delegation)**:
   - Khi cần viết thêm nghiệp vụ phức tạp (ví dụ: luồng thanh toán VNPay, SePay webhook, giữ chỗ ghế), **hãy tạo class riêng**:
     - Controller: `PaymentWebhookResource.java`, `VNPayCallbackResource.java`, `BookingWorkflowResource.java`.
     - Service: `BookingPaymentService.java`, `SeatHoldTimeoutService.java`.
   - Các file này không nằm trong danh sách entity của JDL nên sẽ **vĩnh viễn không bị ảnh hưởng** khi re-generate!
3. **Cơ chế JHipster Needle (`// jhipster-needle-...`)**:
   - Khi cần đăng ký cấu hình bổ sung (như Spring Security URL, Liquibase changelog include), luôn chèn tại vị trí comment needle. JHipster sẽ giữ nguyên nội dung tại needle khi generate lại.

> 📘 **Cẩm nang thực chiến cho lập trình viên**: Xem chi tiết hướng dẫn từng bước và checklist tại [**`docs/guides/JDL_DEVELOPMENT_GUIDE.md`**](docs/guides/JDL_DEVELOPMENT_GUIDE.md).

### Rule 5: Triết lý Mạng Multi-VPS (Zero Localhost / Zero Internal-IP Assumption)
- **CẤM Hardcode**:
  - Không hardcode `localhost`, `127.0.0.1` hay tên container nội bộ (như `http://ms_user:8081`) trong source code hoặc file cấu hình production để gọi sang service khác.
  - Không giả định hạ tầng (Redis, Kafka, MySQL, Consul, Vault) chạy cùng máy chủ với Microservices.
- **BẮT BUỘC Dynamic Configuration**:
  Mọi địa chỉ kết nối external dependencies phải đọc từ biến môi trường hoặc Consul KV:
  - Kafka: `${KAFKA_BROKERS}` (ví dụ: `kafka.phungvip.io.vn:9093`)
  - Redis: `${REDIS_HOST}:${REDIS_PORT}`
  - Elasticsearch: `${ELASTICSEARCH_URIS}`
  - Vault: `${SPRING_CLOUD_VAULT_URI}`
  - Consul: `${SPRING_CLOUD_CONSUL_HOST}:${SPRING_CLOUD_CONSUL_PORT}`
- **Bảo mật mạng đa VPS (Dual-Layer Network)**:
  - **Lớp Layer 7 (HTTP/HTTPS)**: Đi qua Cloudflare Tunnel / Reverse Proxy (Nginx) với SSL/TLS chuẩn (Port 443).
  - **Lớp Layer 4 (TCP: Kafka SSL 9093, Redis 6379, MySQL)**: Phải được bảo mật bằng TLS/SSL hoặc chạy trong mạng riêng ảo Overlay (WireGuard / Tailscale Mesh VPN giữa các VPS).

### Rule 6: Dynamic Service Discovery & Registration
- Khi khởi động, mỗi Microservice đăng ký vào Consul với địa chỉ công khai/định tuyến được của chính nó:
  ```yaml
  spring:
    cloud:
      consul:
        discovery:
          prefer-ip-address: true
          ip-address: ${SERVICE_DISCOVERY_ADDRESS} # Ví dụ: msuser.phungvip.io.vn hoặc IP Overlay Mesh
          port: 443
          scheme: https
  ```
- Nhờ cơ chế này, Service A ở VPS 1 và Service B ở VPS 2 hoàn toàn có thể tự tìm thấy và gọi nhau thông qua Consul Discovery mà không cần biết đối phương đang nằm ở máy chủ nào.

---

## 3. Bản kiểm tra hiện trạng & Tiến triển Multi-VPS (Readiness & Integration Progress)

| Tiêu chí | Trạng thái | Hiện trạng thực tế | Tiến triển & Giải pháp kỹ thuật (Integration Roadmap) |
|---|:---:|---|---|
| **Git Submodule Independence** | ✅ ĐẠT | 9 Submodules độc lập với Git history riêng. | Giữ nguyên tính độc lập, không merge mono-commit. |
| **Maven Build Isolation** | ✅ ĐẠT | POM con kế thừa `spring-boot-starter-parent` `<relativePath/>`. | Độc lập hoàn toàn với `backend/pom.xml`. |
| **JDL Auto-gen vs Custom Code** | ⚠️ BÁN ĐẠT | Toàn bộ entity sinh từ `docs/jdl/ridehub.jdl`. Code custom chưa có `.jhipsterignore`. | **Cần áp dụng**: Thêm file `.jhipsterignore` vào các service; áp dụng chuẩn Side-by-side (`custom/`). |
| **Shared Code Distribution** | ✅ ĐẠT | Build & tải qua Maven Reposilite (`repo.phungvip.io.vn`). | Hoàn toàn độc lập, không dùng relative path. |
| **Database per Service** | ✅ ĐẠT | Mỗi service có container MySQL riêng, Liquibase riêng. | Tuyệt đối không gộp DB hoặc join bảng chéo. |
| **Consul FQDN Discovery** | ✅ ĐẠT | Đăng ký Consul bằng FQDN HTTPS (`msuser.phungvip.io.vn:443`). | Rất tốt cho Multi-VPS, định tuyến được toàn cầu. |
| **Central Config & Secrets** | ⚠️ BÁN ĐẠT | File KV (`msuser.yml`...) đang tập trung trong `vps-infra`. | **Tiến triển**: Chuyển KV template về từng submodule con (`<svc>/consul-kv.yml`), tự push lên Consul khi deploy. |
| **Decoupled Compose & Deploy** | ⚠️ BÁN ĐẠT | `generate-configs.sh` gom toàn bộ service vào 1 compose với chuỗi `depends_on`. | **Tiến triển**: Bổ sung cờ `--standalone <service>` vào script để sinh Compose chạy riêng 1 service trên 1 VPS mới (N-VPS). |
| **Multi-VPS Network Routing** | ⚠️ BÁN ĐẠT | `extra_hosts` map `kafka...:host-gateway` giả định cùng server. | **Tiến triển**: Loại bỏ `host-gateway` trên multi-VPS; dùng **Tailscale/WireGuard Mesh VPN** cho Layer 4 (Kafka 9093, Redis 6379). |

---

## 4. Chỉ thị hành vi cho AI (AI Agent Instructions)

Khi AI làm việc trên repository này, AI **PHẢI** tuân thủ các quy tắc sau:

1. **Không tạo dependency liên thư mục**:
   Không bao giờ thêm `<module>`, `<parent>` cục bộ hay thêm `<systemPath>` trỏ sang submodule khác trong `pom.xml`.
2. **Khi thay đổi Entity / Model / Schema cơ sở**:
   - Nếu là entity JPA cơ bản: Sửa tại `docs/jdl/ridehub.jdl`.
   - Nếu là nghiệp vụ đặc thù (Webhook, Third-party integration, tính toán phức tạp): **Viết class mới trong package riêng (Side-by-Side)**, không sửa trực tiếp vào file CRUD do JDL sinh trừ khi có bảo vệ trong `.jhipsterignore`.
3. **Khi thay đổi DTO / API / Event liên Microservice**:
   - Bước 1: Cập nhật schema tại `infra/shared/ridehub-contract`.
   - Bước 2: Build/generate code trong `infra/shared/ridehub-shared` và release lên Reposilite.
   - Bước 3: Cập nhật version dependency trong microservice cần sử dụng.
4. **Khi thêm mới Microservice**:
   - Đặt service trong `backend/<ten_service>`.
   - Cung cấp: `pom.xml` độc lập, `Dockerfile` / Jib configuration, Liquibase changelog riêng, `bootstrap.yml` kết nối Consul/Vault qua biến môi trường.
   - Không được tạo kết nối cứng tới DB của service khác.
5. **Khi viết cấu hình Docker / Compose / Shell script**:
   - Luôn xem xét: *"Nếu service này chạy trên VPS Frankfurt và Kafka/Consul ở VPS Singapore, cấu hình này có chạy được không?"* Nếu câu trả lời là CÓ, cấu hình đó mới đạt chuẩn!
