package com.example.demo1.service;

import com.example.demo1.model.Dish;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class DishServiceImpl implements dishInterface {

    @Override
    public List<Dish> getAllDishes() {
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish(1, "Phở bò", 50000, true));
        dishes.add(new Dish(2, "Bún chả", 45000, false));
        dishes.add(new Dish(3, "Gỏi cuốn", 30000, true));
        return dishes;
    }
}