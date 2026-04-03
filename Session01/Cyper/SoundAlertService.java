package Session01.Cyper;
import org.springframework.stereotype.Component;

@Component("soundAlert")
public class SoundAlertService implements AlertService {

    @Override
    public void alert(String username, double balance) {
        System.out.println("🔊 [SOUND ALERT] User: " + username +
                " - Balance thấp: " + balance + " VNĐ");
    }
}