package Session02.Ex4_5_6.java.org.example.demo3.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.example.demo3.controller.AuthService;

@Controller
public class AuthController {
    @Autowired


    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          HttpSession session,
                          jakarta.servlet.http.HttpServletRequest request) {

        if("admin".equals(username) && "admin123".equals(password)){
            session.setAttribute("loggedUser", username);
            session.setAttribute("role", "ADMIN");
            return "redirect:/orders";
        }

        AuthService auth = new AuthService();
        String role = auth.login(username, password);

        if (role != null) {
            session.setAttribute("loggedUser", username);
            session.setAttribute("role", role);
            return "redirect:/employees";
        }

        request.setAttribute("error", "Sai tài khoản hoặc mật khẩu");
        return "login";

    }


}
