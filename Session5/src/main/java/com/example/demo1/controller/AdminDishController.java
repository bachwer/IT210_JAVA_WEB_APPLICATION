package com.example.demo1.controller;

import com.example.demo1.model.Dish;
import com.example.demo1.service.AdminDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai3")
public class AdminDishController {

    @Autowired
    private AdminDishService adminDishService;

    @GetMapping("edit/{id}")
    public String editDish(@PathVariable("id") int id, Model model){
        Dish dish = adminDishService.getDishById(id);
        if(dish == null){
            model.addAttribute("errorMessage", "Khoong tim thay");
        }
        model.addAttribute("dish", dish);
        return "bai3/edit-dish";
    }

    @PostMapping("/update/{id}")
    public String updateDish(@PathVariable("id") int id, @ModelAttribute("dish") Dish dish) {
        adminDishService.updateDish(id, dish);
        return "redirect:/bai2/dishes";
    }
}
