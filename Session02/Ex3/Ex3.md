## **1 Vì Sao lỗi login phải dùng request**


**Đúng** 
```Java
    request.setAttribute("error", "Sai Tài Khoản hoặc mật khẩu");
    return "login";
```
- Chỉ tồn tại trong 1 request !
- Khi Reload - > mất luôn
- Thông báo lỗi
- validation

**Sai**
```java
    session.setAttribute("error", "Sai tài khoản")
```
- Tồn tại xuyêt suốt phiên đăng nhập
- Hâu quả -> lỗi Vẫn hiện thị
- Người dùng bị "ám Lỗi"
- có thể hiện thị sai giữa các trang


#### **2 Vì sao totalViewCount phải dùng application Scope**
```java
    application.setAttribute("totalViewCount", count)
```
- Dùng chung cho toàn bộ hệ thống
- Mọi user thấy cùng 1 giá trị
VD:
- A xem -> 1
- B xem -> 2
- A xem lại -> 3

=> Đúng y/c đề bài

#### **Nếu Dùng session Scope;**
kết quả
User A: 1 -> 2 -> 3
User B: 1 -> 2
=> Mỗi người thấy khác nhau -> Sai y/c



## **3. Race Condition là gì?**

Code Gây lỗi

```java
    Integer count = (Integer) application.getAttribute("totalViewCount");
    if(count == null) count = 0 ;
    count++;
    application.setAttribute("totalViewCount", count);
```
Vấn đề
Giả sữ nếu 2 user truy cập cùng lúc 

Thread
A Đọc = 5 ; B đọc = 5
+1 -> 6 ; +1 -> 6
Ghi =6 , ghi = 6
kết quả sai

=> Race Condition = nhiều request cùng truy cập và ghi đè dữ liệu lẫn nhau



Cách Fix Race Condition

**Cách 1 synchronized**

```java
Servlet application = request.getServletContext();
synchronized (application) {
Integer count = (Integer) application.getAttribute("totalViewCount");
    if (count == null) count = 0;
count++;
        application.setAttribute("totalViewCount", count);
}
```
=> Đảm bảo chỉ có 1 luồn đc vào tại 1 thời điểm

**Cách 2: dùng AtomicInteger**

```java
AtomicInteger counter = (AtomicInteger) application.getAttribute("totalViewCount");

if (counter == null) {
    counter = new AtomicInteger(0);
    application.setAttribute("totalViewCount", counter);
}

counter.incrementAndGet();

```
- Thread-safe
- Hiệu năng tốt hơn synchronized








