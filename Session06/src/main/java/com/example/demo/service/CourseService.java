package com.example.demo.service;


import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    public List<Course> getAll() {
        return repo.findAll();
    }

    public List<Course> filter(String level, Double maxFee) {
        return repo.findAll().stream()
                .filter(c -> level == null || c.getLevel().equalsIgnoreCase(level))
                .filter(c -> maxFee == null || c.getTuitionFee() <= maxFee)
                .collect(Collectors.toList());
    }

    public Course getByCode(String code) {
        return repo.findByCode(code);
    }
}