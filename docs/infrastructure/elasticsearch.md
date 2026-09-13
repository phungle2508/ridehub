# HẠ TẦNG: ELASTICSEARCH (SEARCH ENGINE & GEOSPATIAL QUERIES)

> **Phạm vi quản lý**: Tìm kiếm hành trình và tuyến xe tốc độ cao (High-Performance Search), Tìm kiếm trạm đón theo tọa độ GPS (Geospatial & Bounding Box Queries), Xử lý ngôn ngữ tự nhiên tiếng Việt (Vietnamese Full-Text Search), và Đồng bộ dữ liệu tức thời từ MySQL.

---

## 1. Bản chất & Cơ chế hoạt động của Elasticsearch

Trong hệ thống đặt vé xe khách liên tỉnh, Elasticsearch giải quyết bài toán tìm kiếm mà MySQL truyền thống không thể đáp ứng:
* **Inverted Index (Chỉ mục ngược)**: Giúp tìm kiếm từ khóa ("Bến xe Miền Đông", "Hà Nội đi Đà Nẵng") trong hàng triệu bản ghi chỉ mất dưới 50ms mà không gây khóa bảng MySQL.
* **Geospatial Indexing (`geo_point`)**: Hỗ trợ tính toán khoảng cách hình cầu (Haversine Formula) cực nhanh để trả lời câu hỏi: *"Tìm tất cả các điểm đón của tuyến xe này nằm trong bán kính 3km quanh vị trí GPS hiện tại của hành khách"*.
* **Fuzzy Search & Spell Check**: Tự động sửa lỗi chính tả khi người dùng gõ sai tên tỉnh thành hoặc gõ tiếng Việt không dấu (vd: `sai gon` tự hiểu là `Sài Gòn`).

---

## 2. Hiện trạng đã triển khai trong Repo RideHub (As-Is)

Elasticsearch được triển khai tại `infra/vps-infra/docker-compose.yml` (phiên bản Elasticsearch 8.x):

1. **Cấu hình độc lập (Single-Node Cluster)**:
   - Biến môi trường: `discovery.type=single-node`, cấu hình bộ nhớ `ES_JAVA_OPTS=-Xms512m -Xmx512m`.
   - Kết nối qua cổng nội bộ 9200, volume dữ liệu bền vững `elasticsearch_data`.
2. **Tích hợp với `ms_route`**:
   - Submodule `ms_route` sử dụng Spring Data Elasticsearch (`ElasticsearchRepository`) để lưu trữ các index `route`, `trip`, `station`.
   - Cung cấp API tìm kiếm chuyến xe cho Frontend và Gateway.

---

## 3. Những hạn chế & Tiềm năng chưa khai thác

| Tiềm năng chưa khai thác | Hiện trạng thực tế tại RideHub | Rủi ro / Điểm nghẽn |
|---|---|---|
| **Bộ phân tích tiếng Việt (Vietnamese Analyzer)** | Mới dùng bộ phân tích mặc định (`standard analyzer`). | Tìm kiếm không dấu / có dấu tiếng Việt ("Ha Noi" vs "Hà Nội") hoặc từ ghép có thể trả về kết quả thiếu chính xác. |
| **Cơ chế đồng bộ dữ liệu (Data Sync)** | Đang dựa vào logic code Java của `ms_route` (khi Admin sửa tuyến trên web thì code tự gọi Elasticsearch save). | Nếu lệnh gọi sang Elasticsearch bị timeout, dữ liệu giữa MySQL và Elasticsearch bị lệch nhau (Inconsistent Data). |
| **Geospatial Distance Sorting** | Chưa tận dụng triệt để index `geo_point` để sắp xếp kết quả chuyến xe theo vị trí gần khách nhất. | Người dùng phải tự chọn bến xe thủ công thay vì hệ thống tự gợi ý điểm đón gần nhất. |
| **Quản lý RAM & Bộ nhớ đệm** | Heap size 512MB chỉ phù hợp môi trường dev nhỏ. | Khi lượng dữ liệu chuyến xe tăng cao trong mùa cao điểm, Elasticsearch có thể bị crash do lỗi Out-Of-Memory (OOM). |

---

## 4. Bảng kế hoạch lộ trình (Elasticsearch Roadmap)

| Giai đoạn | Tính năng | Mục tiêu | Độ ưu tiên | Vị trí can thiệp |
|:---:|---|---|:---:|---|
| **P1** | **Cài đặt Plugin Phân tích tiếng Việt** | Tích hợp plugin `analysis-icu` hoặc bộ phân tích từ ghép tiếng Việt để tìm kiếm không dấu chuẩn xác 100%. | **P0 (Trải nghiệm tìm kiếm)** | • Dockerfile Elasticsearch |
| **P2** | **Đồng bộ tự động qua Kafka (CDC Pipeline)** | `ms_route` lưu MySQL $\rightarrow$ Kafka Event $\rightarrow$ Elasticsearch Consumer cập nhật index (Đảm bảo không bao giờ lệch dữ liệu). | **P1 (Tính toàn vẹn)** | • `backend/ms_route` |
| **P3** | **Tối ưu Geo-Queries cho Điểm đón/trả** | Lưu tọa độ GPS các trạm trung chuyển dưới dạng `geo_point`, hỗ trợ tìm trạm xe gần nhất trong bán kính $R$ km. | **P1 (Nghiệp vụ cốt lõi)** | • Index mapping `ms_route` |
| **P4** | **Index Lifecycle Management (ILM)** | Tự động archive hoặc xóa các index chuyến xe đã hoàn thành quá 6 tháng để tiết kiệm dung lượng đĩa và RAM. | **P2 (Tối ưu hạ tầng)** | • Elasticsearch ILM Policy |
| **P5** | **Bật TLS & RBAC nội bộ** | Kích hoạt bảo mật Elastic Security, cấp user/pass riêng cho `ms_route` kết nối Elasticsearch. | **P3 (Bảo mật)** | • `vps-infra/docker-compose.yml` |

---

## 5. Chi tiết kỹ thuật & Hướng dẫn triển khai

### A. Cấu hình Index Mapping hỗ trợ Geo-Point và Tiếng Việt (`ms_route`)
Định nghĩa cấu trúc mapping cho trạm xe và chuyến xe:

```json
PUT /ridehub_stations
{
  "settings": {
    "analysis": {
      "analyzer": {
        "vietnamese_analyzer": {
          "tokenizer": "icu_tokenizer",
          "filter": ["icu_folding", "lowercase"]
        }
      }
    }
  },
  "mappings": {
    "properties": {
      "stationId": { "type": "keyword" },
      "stationName": {
        "type": "text",
        "analyzer": "vietnamese_analyzer"
      },
      "address": { "type": "text" },
      "location": {
        "type": "geo_point"
      }
    }
  }
}
```

### B. Truy vấn tìm trạm đón xe gần vị trí GPS của hành khách
Khi ứng dụng di động gửi tọa độ của khách (`lat: 10.7769, lon: 106.7009`), backend gọi Elasticsearch:

```json
POST /ridehub_stations/_search
{
  "query": {
    "bool": {
      "must": {
        "match": { "stationName": "Bến xe" }
      },
      "filter": {
        "geo_distance": {
          "distance": "5km",
          "location": {
            "lat": 10.7769,
            "lon": 106.7009
          }
        }
      }
    }
  },
  "sort": [
    {
      "_geo_distance": {
        "location": {
          "lat": 10.7769,
          "lon": 106.7009
        },
        "order": "asc",
        "unit": "km"
      }
    }
  ]
}
```
*Kết quả trả về danh sách các điểm đón xe trong bán kính 5km, sắp xếp theo thứ tự từ gần nhất đến xa nhất!*

