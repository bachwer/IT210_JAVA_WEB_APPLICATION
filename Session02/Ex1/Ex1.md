**Phần 1**

1 Lỗi trong MyWebAppInitializer.java

Cấu Hình sai
```Java
    return new String[] {/api/*}
```

- DispatcherServlet là servlet trung tam cua String MVC
- Mapping "/api/*" nghia la DispatcherServlet chi xu ly cac URL bat dau bang api

VD
- **/api/welcome -> có xử lý**
- **/welcome -> Không xử lý**


Luồng thực tế

Browser -> Tomcat -> ko Match /api/ -> không đi vào dispatcherServlet -> 404

=> DispatcherServlet Đang nghe /api/*, Nhưng Request là /welcome  -> ko match trả về 404

2 Lỗi Trong webConfig.java

Cấu hình sai
```java
@componentScan(basePackages = "com.demo.service");
```
Vấn đề 
Spring chỉ scan package "com.demo.service"

trong khi : WelcomeController nằm ở: com.demo.controller


=> Spring không tạo bean cho WelcomeController
=> Không có controller nào đc đăng kí
=> HandlerMapping Không tìm thất handler

**Luồng Lỗi**

DispatcherServlet -> HandlerMapping -> không Tìm thấy @Controller -> 404(No mapping found)

- @Controller -> Trạng Thái Không Đc Scan
- @Service -> trạng thái có
- Mapping/welcome Không tồn tại



3 Nê