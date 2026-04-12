package com.example.demo.repository;

import com.example.demo.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {

    private static List<Course> courses = new ArrayList<>();

    static {
        courses.add(new Course("1","IELTS-6.5","IELTS 6.5",
                "Lộ trình IELTS 6.5","Mr. A",120,
                "Intermediate", 5000000, 20, 25, "2026-05-01"));

        courses.add(new Course("2","IELTS-7.0","IELTS 7.0",
                "Lộ trình IELTS 7.0","Ms. B",150,
                "Advanced", 7000000, 25, 25, "2026-06-01"));

        courses.add(new Course("3","TOEIC-500","TOEIC 500",
                "Cơ bản TOEIC","Mr. C",90,
                "Beginner", 3000000, 0, 30, "2026-04-20"));

        // thêm ít nhất 5 khóa nếu cần
    }


    public List<Course> findAll() {
        return courses;
    }


    public Course findByCode(String code) {
        return courses.stream()
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }


    public boolean deleteByCode(String code) {
        return courses.removeIf(c -> c.getCode().equals(code));
    }
}