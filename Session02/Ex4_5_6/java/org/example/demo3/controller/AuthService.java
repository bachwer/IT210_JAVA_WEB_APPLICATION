package Session02.Ex4_5_6.java.org.example.demo3.controller;

public class AuthService {


    public String login(String username, String password){
        if("hr_manager".equals(username) && password.equals("hr_manager")){
            return "manager";
        }
        if("hr_staff".equals(username) && password.equals("hr_staff")){
            return "staff";
        }

        return null;
    }
}
