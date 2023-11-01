package com.example.lab1.myapp.controller;

import com.example.lab1.myapp.dto.CourseDto;
import com.example.lab1.myapp.service.CourseService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<CourseDto> getAllCourses() {
        System.out.println("get all students");
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public CourseDto getCourseById(@PathVariable Integer id) {
        System.out.println("get student by id");
        return courseService.findById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable Integer id) {
        System.out.println("delete course by id");
        courseService.delete(id);
    }

    @PutMapping("/{id}")
    public void updateCourseById(@PathVariable Integer id, @RequestBody CourseDto course) {
        System.out.println("update course by id");
        courseService.update(id, course);
    }

}
