package com.example.demo.controller;


import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    // =====================================================
    // 1. DANH SÁCH + FILTER KHÓA HỌC
    // =====================================================
    @GetMapping("/course/list")
    public String listCourses(
            @RequestParam(required = false, defaultValue = "") String level,
            @RequestParam(required = false, defaultValue = "0") Double maxFee,
            Model model,
            @ModelAttribute("error") String error,
            @ModelAttribute("success") String success
    ) {

        List<Course> courses = courseService.filter(
                level.isEmpty() ? null : level,
                maxFee == 0 ? null : maxFee
        );

        model.addAttribute("courses", courses);
        model.addAttribute("level", level);
        model.addAttribute("maxFee", maxFee);

        return "course-list";
    }

    // =====================================================
    // 2. XEM CHI TIẾT KHÓA HỌC
    // =====================================================
    @GetMapping("/course/detail/{code}")
    public String courseDetail(@PathVariable String code, Model model,
                               RedirectAttributes redirect) {

        Course course = courseService.getByCode(code);

        if (course == null) {
            redirect.addFlashAttribute("error", "Không tìm thấy khóa học");
            return "redirect:/course/list";
        }

        model.addAttribute("course", course);
        return "course-detail";
    }

    // =====================================================
    // 3. FORM EDIT KHÓA HỌC
    // =====================================================
    @GetMapping("/course/edit/{code}")
    public String editForm(@PathVariable String code, Model model,
                           RedirectAttributes redirect) {

        Course course = courseService.getByCode(code);

        if (course == null) {
            redirect.addFlashAttribute("error", "Khóa học không tồn tại");
            return "redirect:/course/list";
        }

        model.addAttribute("course", course);
        return "course-edit";
    }

    // =====================================================
    // 4. UPDATE KHÓA HỌC (PRG PATTERN)
    // =====================================================
    @PostMapping("/course/update")
    public String updateCourse(@ModelAttribute Course form,
                               RedirectAttributes redirect) {

        Course course = courseService.getByCode(form.getCode());

        if (course == null) {
            redirect.addFlashAttribute("error", "Không tìm thấy khóa học để cập nhật");
            return "redirect:/course/list";
        }

        // update fields allowed
        course.setTuitionFee(form.getTuitionFee());
        course.setStartDate(form.getStartDate());

        redirect.addFlashAttribute("success", "Cập nhật khóa học thành công");

        return "redirect:/course/list";
    }

    // =====================================================
    // 5. XÓA KHÓA HỌC (BUSINESS RULE)
    // =====================================================
    @PostMapping("/course/delete/{code}")
    public String deleteCourse(@PathVariable String code,
                               RedirectAttributes redirect) {

        Course course = courseService.getByCode(code);

        if (course == null) {
            redirect.addFlashAttribute("error", "Không tìm thấy khóa học");
            return "redirect:/course/list";
        }

        // Bẫy nghiệp vụ: không được xóa nếu đã có học viên
        if (course.getStudentCount() > 0) {
            redirect.addFlashAttribute("error",
                    "Không thể hủy khóa học đã có học viên đăng ký");
            return "redirect:/course/list";
        }

        courseRepository.deleteByCode(code);

        redirect.addFlashAttribute("success", "Hủy khóa học thành công");

        return "redirect:/course/list";
    }

    @GetMapping("/course/edit/{code}")
    public String editForm(@PathVariable String code, Model model) {

        Course course = courseService.getByCode(code);

        if (course == null) {
            return "redirect:/course/list";
        }

        model.addAttribute("course", course);
        return "course-edit";
    }
}