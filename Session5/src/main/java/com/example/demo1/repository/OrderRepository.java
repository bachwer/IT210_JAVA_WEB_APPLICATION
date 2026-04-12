package com.example.demo1.repository;

import com.example.demo1.model.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository {

    private List<Dish> dishes = new ArrayList<>();

    public OrderRepository(){
        dishes.add(new Dish(1, "Phở Bò", 50000, true));
        dishes.add(new Dish(2, "Bún Chả", 45000, true));
        dishes.add(new Dish(3, "Gỏi Cuốn", 30000, true));
    }

    public Optional<Dish> findById(int id){
        return dishes.stream().filter(d -> d.getId() == (id)).findFirst();
    }


    public List<Dish> findAll() {
        return dishes;
    }

}
