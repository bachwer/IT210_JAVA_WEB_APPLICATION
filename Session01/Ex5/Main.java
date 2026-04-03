package Session01.Ex5;


import Session01.Ex5.config.AppConfig;
import Session01.Ex5.model.SystemConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        SystemConfig config = context.getBean(SystemConfig.class);

        System.out.println("Chi nhánh: " + config.getBranchName());
        System.out.println("Giờ mở cửa: " + config.getOpeningHour());
    }
}