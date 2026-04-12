package com.example.demo1.service;

import com.example.demo1.model.Dish;
import com.example.demo1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Dish getDishById(int id) throws RuntimeException {
        Optional<Dish> dishOpt = repository.findById(id);
        if (dishOpt.isEmpty()) {
            throw new RuntimeException("Không tìm thấy món ăn!");
        }
        return dishOpt.get();
    }
}