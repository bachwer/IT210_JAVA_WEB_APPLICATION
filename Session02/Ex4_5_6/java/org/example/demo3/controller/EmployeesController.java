package Session02.Ex4_5_6.java.org.example.demo3.controller;

import jakarta.servlet.http.HttpSession;
import org.example.demo3.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class EmployeesController {
    @GetMapping("/employees")
    public String listEmployees(HttpSession session, Model model) {

        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        EmployeeService em = new EmployeeService();

        model.addAttribute("employees", em.findAll());
        model.addAttribute("totalTechSalary", em.totalSalaryTechDept());

        return "employees";
    }

}
