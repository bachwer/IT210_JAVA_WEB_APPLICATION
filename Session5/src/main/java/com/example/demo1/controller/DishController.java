package com.example.demo1.controller;







import com.example.demo1.model.Dish;
import com.example.demo1.service.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DishController {

    @Autowired
    private DishServiceImpl dishService;

    @GetMapping("/bai2/dishes")
    public String showDishList(Model model) {
        List<Dish> dishes = dishService.getAllDishes();
        model.addAttribute("dishes", dishes);
        return "bai2/dish-list";
    }
}