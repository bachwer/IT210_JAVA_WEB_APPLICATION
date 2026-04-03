```java
public RechargeService() {
    // Problem matic line (Hard-coded dependency)
    this.gateway = new InternalPaymentGateway(); 
}
```

* Dòng lệnh Tạo thủ công Trong RechargeService
* Điều này khiến lớp này liên kết chặt chẽ với  InternalPaymentGateway
* Điều này vi phạm nguyên tắc IoC (Ngược lại quyền kiểm soát) vì lớp đó tự kiểm soát việc tạo đối tượng thay vì để một container bên ngoài (như Spring) xử lý việc đó.


**Consequences**

* Không thể dễ dàng thêm các cổng thanh toán mới (Momo, ZaloPay)
* Phải chỉnh sửa code cũ → vi phạm nguyên lý Open/Closed Principle
* Khó bảo trì và mở rộng hệ thống
* Khó viết Unit Test

**Correct Idea**

* Không tự tạo dependency bằng new
* Nhận dependency từ bên ngoài (Inject)
```JAVA
public RechargeService(PaymentGateway gateway) {
    this.gateway = gateway;
}
```
**Conclusion**

* Service không nên biết cách tạo object
* Chỉ nên sử dụng object được cung cấp

	•	Code sai vì hard-code dependency, làm mất tính linh hoạt của hệ thống
	•	Vi phạm IoC → dẫn đến tight coupling
	•	Sử dụng Dependency Injection (DI) giúp:
	•	Giảm phụ thuộc giữa các module
	•	Dễ mở rộng (thêm Momo, ZaloPay)
	•	Dễ bảo trì
	•	Dễ kiểm thử