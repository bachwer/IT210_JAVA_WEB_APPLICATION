package com.example.demo1.controller;

import com.example.demo1.model.Dish;
import com.example.demo1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bai5")
public class DishDetailController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/{id}")
    public String showDishDetail(@PathVariable("id") int id, Model model) {
        try {
            Dish dish = orderService.getDishById(id);
            model.addAttribute("dish", dish);
            return "bai5/order";
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "redirect:/bai5/list";
        }
    }

    @GetMapping("/list")
    public String showDishList() {
        return "bai5/dish-list"; // kế thừa layout bài 4
    }
}