package com.example.demo.controller;


import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/courses")
//@NoArgsConstructor()
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<CourseDto> getCourses(){
        return courseService.finAll();
    }

    @PostMapping
    public void addCourse(@RequestBody Course course){
        courseService.save(course);
    }

    @PutMapping("/{courseId}")
    public void editCourse(@PathVariable int courseId, @RequestBody Course course){
        courseService.edit(courseId, course);
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable int courseId){
    courseService.deleteCourse(courseId);
    }


}
