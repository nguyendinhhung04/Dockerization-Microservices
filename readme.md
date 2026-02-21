# Project: Dockerization Microservices & Network Isolation

## 📌 Đặt vấn đề

> Trong môi trường thực tế, microservices không thể chạy theo kiểu "jar-er" mà cần đưa vào trong các **Container** để kiểm soát hiệu quả, kèm tách biệt các service sao cho không phụ thuộc trong runtime. Sử dụng Docker đưa các service vào container.

### ⚙️ Cấu hình và Môi trường (Configuration & Environment)
* Với docker phần thiết lập (configuration) rất quan trọng. Mỗi container service đều cần phải config.
* Nó ảnh hưởng cấu trúc của dự án rõ ràng, dễ bắt lỗi, giúp dễ xây dựng các kiến trúc nghiệp vụ.
* **Câu hỏi đặt ra:** Cần thiết kế phần Configuration và Environment Variables ra sao cho việc deploy container thuận tiện, tường minh?
    * *Hướng giải quyết:* Tìm kiếm và tham khảo các source code configuration mẫu trên mạng.

### 🌐 Giao tiếp mạng (Networking)
* Vấn đề phát sinh khi đưa service vào các container: Không thể gọi dạng `localhost` mà cần có một hệ thống giao tiếp giữa các services.
* Cần xử lý các bài toán:
    * Vấn đề về **Port**.
    * Giao tiếp dữ liệu giữa các container (Service Discovery, dùng Docker Bridge Network).
    * Giao tiếp Client với các services (Dùng **API Gateway** - *Đang nghiên cứu, sẽ cập nhật thêm*).

### 🏗️ Kiến trúc nghiệp vụ
* Cần xây dựng một kiến trúc nghiệp vụ để demo bài toán.
* Nghiệp vụ là: *(Đang cân nhắc, sẽ cập nhật sau)*.

---

## 🚀 Các vấn đề mở rộng

| Nhóm nội dung | Chi tiết nghiên cứu |
| :--- | :--- |
| **Design Patterns** | Áp dụng các design pattern và triển khai với Docker để làm demo tường minh và có nội dung hơn. |
| **Nghiên cứu chéo** | Tìm hiểu nội dung của các nhóm khác, đưa các nội dung đó áp dụng với Docker xem có vấn đề nào phát sinh để lấy giải pháp làm nội dung. |

### 📈 Scaling (Khả năng mở rộng)
* Khi được đưa vào các container, việc triển khai và mở rộng các service sẽ dễ dàng hơn. Ví dụ như dùng **Kubernetes**, giúp quản lý thêm, bớt các container để cân bằng tải.
* **Các câu hỏi nghiên cứu:**
    * Khi nào thì nên compose đủ, khi nào cần Swarm, khi nào cần Kubernetes?
    * Có khả năng Auto-scaling được không?
    * Khi nào thì nên scale? Scale xong CPU, Memory có đủ không?
    * *Keywords:* `Context switching overhead`, `Latency performance`, `OOM kill`.

### 🔍 Service Discovery & Load Balancing
* Vấn đề IP, Port, Service Network Discovery khi Auto-scaling sẽ khác với việc không thể scale.
    * *Keywords:* `Docker Internal DNS`, `Docker Swarm`.
* Vấn đề phân phối request đến các service container sao cho 1 container không bị quá tải (Nội dung này khá *outscope*).

### 🛡️ Tính sẵn sàng (Resilience)
* Vấn đề khi sập 1 container:
    * Các request trên container đó có bị fail không?
    * Hệ thống có tự hồi phục rồi xử lý tiếp hay không?