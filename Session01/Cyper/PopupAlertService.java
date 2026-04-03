package Session01.Cyper;
import org.springframework.stereotype.Component;

@Component("popupAlert")
public class PopupAlertService implements AlertService {

    @Override
    public void alert(String username, double balance) {
        System.out.println("💬 [POPUP ALERT] User: " + username +
                " - Balance thấp: " + balance + " VNĐ");
    }
}