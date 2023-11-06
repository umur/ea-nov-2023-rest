package com.example.RestFulllab.controller;

import com.example.RestFulllab.entity.Course;
import com.example.RestFulllab.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Course> getCourses()
    {
        return courseService.getall();
    }

    @PostMapping
    public void saveCourse(@RequestBody Course course)
    {
        courseService.save(course);
    }

}
