Phần 1 


| # | Vị trí (dòng/thành phần) | Loại vấn đề | Mô tả chi tiết hậu quả |
|---|--------------------------|-------------|------------------------|
| 1 | `<%! private int requestCounter = 0; %>` | Race Condition | Biến khai báo ở Declaration được chia sẻ giữa nhiều request (multi-thread). Có thể gây sai lệch dữ liệu khi nhiều người truy cập đồng thời. Không thread-safe. |
| 2 | `<% for(...) { %>` | Logic trong View (Code Smell) | JSP chứa vòng lặp Java → vi phạm nguyên tắc "Thin View". Làm code khó đọc, khó maintain và test. |
| 3 | `<% if(...) { %>` | Business Logic trong View | Điều kiện xử lý nghiệp vụ nằm trong View thay vì Controller/Service → phá vỡ kiến trúc MVC. |
| 4 | `<%= student.getName() %>` | XSS (Cross-Site Scripting) | In trực tiếp dữ liệu ra HTML mà không escape → người dùng có thể inject JavaScript độc hại. |
| 5 | `<%= request.getParameter("name") %>` | XSS nghiêm trọng | Lấy dữ liệu trực tiếp từ request và hiển thị → cực kỳ nguy hiểm, dễ bị tấn công XSS. |
| 6 | `<!-- comment -->` | Sai loại comment | HTML comment vẫn được gửi về client → có thể lộ thông tin nội bộ. |
| 7 | `<%= totalScore; %>` | Syntax Error | Expression không được chứa dấu `;` → gây lỗi render hoặc output sai. |
| 8 | Scriptlet `<% %>` trộn với HTML | Code Smell | Trộn Java và HTML → khó đọc, khó debug, không theo best practice hiện đại. |
| 9 | Sử dụng Java code trong JSP | Vi phạm MVC | JSP không còn là View thuần mà kiêm luôn xử lý logic → khó mở rộng hệ thống. |
| 10 | Không escape dữ liệu đầu ra | Security Issue | Không sử dụng cơ chế escape (như `<c:out>`) → toàn bộ dữ liệu hiển thị có nguy cơ bị tấn công. |

---

Trang JSP hiện tại vi phạm nhiều nguyên tắc Quan trọng
- Không tuân thủ kiến trúc MVC (Logic nằm trong View)
  - Không đảm bảo
  - Khó bảo trì, mở rộng
  - Khó test
  - Dễ bị lỗi khi render
  - Dễ bị tấn công XSS
  - Không tuân thủ best practice hiện đại (không sử dụng Expression Language, JSTL)
- Dễ bị tấn công XSS (Lấy dữ liệu trực tiếp từ request và hiển thị mà không escape)
- Code khó đọc, khó debug (Trộn Java và HTML, sử dụng scriptlet)
- Có thể lộ thông tin nội bộ (HTML comment)
- Không thread-safe (Biến requestCounter chia sẻ giữa nhiều request)



Đúng
- Tuân thủ kiến trúc MVC (Logic nằm trong Controller/Service, View chỉ hiển thị)
  - Dễ bảo trì, mở rộng
  - Dễ test
  - An toàn khi render
  - Sử dụng Expression Language và JSTL để tránh scriptlet
  - Sử dụng cơ chế escape để tránh XSS
    - Thread-safe (Không sử dụng biến chia sẻ giữa các request)
      - Không lộ thông tin nội bộ (Không sử dụng HTML comment chứa thông tin nhạy cảm)
      - Dễ đọc, dễ debug (Tách biệt rõ ràng giữa logic và view)
      - Tuân thủ best practice hiện đại (Không sử dụng scriptlet, sử dụng EL và JSTL)