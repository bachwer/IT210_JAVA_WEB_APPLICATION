package org.example.service;

import org.example.model.RestaurantTable;
import org.example.repository.TableRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableService {

    private final TableRepository repo;

    public TableService(TableRepository repo) {
        this.repo = repo;
    }

    public List<RestaurantTable> filterByCapacity(Integer cap) {
        if (cap == null) return repo.findAll();
        return repo.findAll().stream()
                .filter(t -> t.getCapacity() >= cap)
                .collect(Collectors.toList());
    }

    public RestaurantTable getById(int id) {
        return repo.findById(id);
    }

    public void updateStatus(int id, String status) {
        RestaurantTable t = repo.findById(id);
        if (t != null) t.setStatus(status);
    }

    public String delete(int id) {
        RestaurantTable t = repo.findById(id);
        if (t != null && "Đang dùng".equals(t.getStatus())) {
            return "Không thể xóa bàn đang có khách!";
        }
        repo.delete(id);
        return "Xóa thành công";
    }
}