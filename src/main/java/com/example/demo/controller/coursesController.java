package com.example.demo.controller;

import com.example.demo.dto.CourseDTO;
import com.example.demo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
@Validated
public class coursesController {

    final CourseService courseService;

    @GetMapping()
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }


    @GetMapping("/{id}")
    public CourseDTO findById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping()
    public CourseDTO save(@RequestBody CourseDTO course) {
        return courseService.addCourse(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    @PutMapping("/{id}")
    public CourseDTO update(@PathVariable Long id, @RequestBody CourseDTO course) {
        return courseService.updateCourse(id, course);
    }

}
