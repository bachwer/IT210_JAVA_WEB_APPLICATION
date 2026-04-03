```java
@Component
public class PlaySession {
    private double playTime = 0;

    public void addTime(double time) {
        this.playTime += time;
    }
}
```
-- > Mặc Địng ,Trong Spring Framework,Bean sẽ tạo  phạm Vi **Singleton** 


**What does Singleton mean?**
- Chỉ có 1 instance của PlaySession tạo trong Application 
```text
    All users -> use the same PlaySession Object
```
**Why Does The bug Happen?**
```Java
    private double playTime = 0;    
```
- Biến playTime sẽ dùng chung bởi đối tượng
- Mọi người có thể thay đổi về cùng một Playtime

**Problem Summary**
* PlaySession là Bean dạng singleton 
* Tất cả máy dùng chung một instance
* playTime trở thành dữ liệu dùng chung
* Dẫn đến tính tiền sai

**Concept**
Singleton Scope
```text
1 Bean -> Shared across entire application
```


•	Mỗi phiên chơi phải độc lập theo từng người dùng
•	Singleton gây ra:
•	Dữ liệu bị dùng chung
•	Sai lệch dữ liệu
•	Tính toán không chính xác