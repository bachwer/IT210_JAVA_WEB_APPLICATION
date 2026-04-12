```java

@Bean
public SpringResourceTemplateResolver templateResolver() {
    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
    resolver.setPrefix("/WEB-INF/views");
    resolver.setSuffix(".jsp");
    resolver.setCharacterEncoding("UTF-8");
    return resolver;
}
```


1 Sai suffix
- Hiện tại code trên đag dùng .jps cho Thymeleaf
- Thymeleaf chỉ đọc file HTML(Trừ khi dùng chế độ legacy)
- Nếu khong đổi, Thymeleaf sẽ tìm file .jps -> lỗi 500

2 Sai prefix
- thư mục /WEB-INF/views là chuẩn JPS cũ
- Thymeleaf Trong String 7 với Jakarta EE11 thường đặt template HTML trong /WEB-INF/template
- Nếu không đổi, Thymeleaf sẽ không tim thấy file .html
- 

