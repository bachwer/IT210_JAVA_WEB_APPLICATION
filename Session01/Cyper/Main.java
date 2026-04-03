package Session01.Cyper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        PlaySessionService service =
                context.getBean(PlaySessionService.class);

        // 🎮 Test case
        service.checkBalance("player1", 3000);
        service.checkBalance("vip_user", 10000);
        service.checkBalance("", 2000);
        service.checkBalance("bug_user", -50);
    }
}