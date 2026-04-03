| Tiêu chí                | Constructor Injection | Field Injection | Setter Injection |
|------------------------|----------------------|----------------|------------------|
| Dependency bắt buộc     | Rõ ràng              | Không rõ       | Không            |
| Tính an toàn            | Cao                  | Thấp           | Trung bình       |
| Dễ test                 | Rất tốt              | Khó            | Trung bình       |
| Tính bất biến           | Có                   | Không          | Không            |
| Dễ đọc                  | Cao                  | Thấp           | Trung bình       |
| Khuyến nghị             | Nên dùng             | Không nên      | Dùng khi optional |


** Các phương án triển khai**

Constructor Injection

```java
public class NotificationService {

    private final EmailSender emailSender;
    private final SmsSender smsSender;

    public NotificationService(EmailSender emailSender, SmsSender smsSender) {
        this.emailSender = emailSender;
        this.smsSender = smsSender;
    }
}
```

Field Injection

```java
public class NotificationService {

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private SmsSender smsSender;
}
```

Setter Injection

```java
public class NotificationService {

    private EmailSender emailSender;
    private SmsSender smsSender;

    public void setEmailSender(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void setSmsSender(SmsSender smsSender) {
        this.smsSender = smsSender;
    }
}
```

6. Phân tích bẫy dữ liệu

Trường hợp: SMS bị lỗi kết nối

Nếu hệ thống gửi SMS thất bại giữa chừng:

Với Constructor Injection

```java
try {
    smsSender.send();
} catch (Exception e) {
    emailSender.send();
}
```


* Có thể fallback sang Email	
* Không bị null dependency
* Hệ thống ổn định






