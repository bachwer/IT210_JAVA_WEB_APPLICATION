package org.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ex4")
public class ProductController {

    @GetMapping("/product")
    public String getProduct(
            @RequestParam("category") String category,
            @RequestParam("limit") int limit,
            ModelMap model

    ){

        model.addAttribute("category", category)
                .addAttribute("limit", limit)
                .addAttribute("message", "search Success !");


        return "productList";

    }
}
