package Session01.Ex5.model;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemConfig{
    @Value("Cyber Center HaNoi")
    private String branchName;

    @Value("08:00 AM")
    private String openingHour;

    public String getBranchName(){
        return branchName;
    }

    public String getOpeningHour() {
        return openingHour;
    }
}
