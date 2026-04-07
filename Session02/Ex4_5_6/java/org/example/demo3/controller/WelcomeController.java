package Session02.Ex4_5_6.java.org.example.demo3.controller;

import jakarta.annotation.PostConstruct;
import org.example.demo3.model.Entity.student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WelcomeController {

    @GetMapping("/welcomeEx1")
    public String welcome(Model model) {
        model.addAttribute("staffName", "Nguyễn Văn An");
        model.addAttribute("department", "Phòng Kỹ thuật");
        return "welcomeEx1";
    }

    @GetMapping("/Ex2")
    public String Ex2(Model model){
        List<student> students = new ArrayList<>();

        students.add(new student("Nguyen Van A", "HN", 18, 3.2));
        students.add(new student("Nguyen Van B", "HCM", 19, 3.7));
        students.add(new student("Nguyen Van D", "HN", 28, 3.6));
        students.add(new student("Nguyen Van C", "HCM", 20, 3.9));
        students.add(new student("Nguyen Van E", "HN", 18, 3.3));

        model.addAttribute("studentList", students);
        model.addAttribute("reportTitle", "Báo cáo điểm cuối kỳ");
        return "Ex2";
    }



    @PostConstruct
    public void init() {
        System.out.println(">>> Controller loaded <<<");
    }
}