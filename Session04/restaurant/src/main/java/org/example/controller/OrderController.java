package org.example.controller;


import org.example.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ex3/orders")
public class OrderController {
     OrderService orderService ;



    @GetMapping("/{id}")
    public String getOrder(@PathVariable("id") int id) {
        return orderService.getOrder(id);
    }
    @PostMapping
    public String createOrder() {
        return orderService.createOrder();
    }
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable("id") int id) {
        return orderService.deleteOrder(id);
    }
    @ExceptionHandler(Exception.class)
    public String handleError(Exception e) {
        return "ID must is number";
    }


}
