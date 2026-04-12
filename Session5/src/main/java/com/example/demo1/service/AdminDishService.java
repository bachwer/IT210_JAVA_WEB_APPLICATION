package com.example.demo1.service;

import com.example.demo1.model.Dish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminDishService {

    // Demo: lưu danh sách tạm thời
    private final List<Dish> dishes = new ArrayList<>();

    public AdminDishService() {
        dishes.add(new Dish(1, "Phở bò", 50000, true));
        dishes.add(new Dish(2, "Bún chả", 45000, true));
        dishes.add(new Dish(3, "Gỏi cuốn", 20000, false));
    }

    public Dish getDishById(int id) {
        return dishes.stream()
                .filter(d -> d.getId() == (id))
                .findFirst()
                .orElse(null);
    }

    public void updateDish(int id, Dish updatedDish) {
        for (int i = 0; i < dishes.size(); i++) {
            if (dishes.get(i).getId() == (id)) {
                dishes.set(i, updatedDish);
                break;
            }
        }
    }

    public List<Dish> getAllDishes() {
        return dishes;
    }
}