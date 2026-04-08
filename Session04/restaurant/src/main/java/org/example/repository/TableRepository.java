package org.example.repository;

import org.example.model.RestaurantTable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TableRepository {

    private final List<RestaurantTable> tables = new ArrayList<>();

    public TableRepository() {
        tables.add(new RestaurantTable(1, 2, "Trống"));
        tables.add(new RestaurantTable(2, 4, "Đang dùng"));
        tables.add(new RestaurantTable(3, 6, "Trống"));
    }

    public List<RestaurantTable> findAll() {
        return tables;
    }

    public RestaurantTable findById(int id) {
        return tables.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    public void delete(int id) {
        tables.removeIf(t -> t.getId() == id);
    }
}