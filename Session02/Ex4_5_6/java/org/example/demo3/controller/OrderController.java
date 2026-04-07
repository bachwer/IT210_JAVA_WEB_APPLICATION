package Session02.Ex4_5_6.java.org.example.demo3.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.demo3.model.Entity.order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {
    @GetMapping("/orders")
    public String orders(HttpSession session, HttpServletRequest request){
        if(session.getAttribute("loggedUser") == null){
            return "redirect:/login";
        }
        List<order> list = new ArrayList<>();

        list.add(new order("OD01", "Laptop", 15000000, new Date()));
        list.add(new order("OD02", "Mouse", 200000, new Date()));
        list.add(new order("OD03", "Keyboard", 500000, new Date()));


        request.setAttribute("orderList", list);
        ServletContext application = request.getServletContext();
        synchronized (application){
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if(count == null) count = 0;
            count++;
            application.setAttribute("totalViewCount", count);
        }
        return "orders";
    }
}
