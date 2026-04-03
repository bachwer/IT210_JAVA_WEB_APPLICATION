package Session01.Cyper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PlaySessionService {

    private final AlertService alertService;

    // Constructor Injection
    public PlaySessionService(
            @Qualifier("soundAlert") AlertService alertService
    ) {
        this.alertService = alertService;
    }

    public void checkBalance(String username, double balance) {

        // 🚨 Bẫy dữ liệu lỗi
        if (username == null || username.trim().isEmpty()) {
            System.out.println("⚠️ Username không hợp lệ!");
            return;
        }

        if (balance < 0) {
            System.out.println("⚠️ Balance bị lỗi (âm)! Kiểm tra hệ thống DB.");
            return;
        }

        // 🎯 Logic nghiệp vụ
        if (balance < 5000) {
            alertService.alert(username, balance);
        } else {
            System.out.println("✅ User: " + username + " vẫn đủ tiền.");
        }
    }
}