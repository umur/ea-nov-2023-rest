package com.example.lab2.Controller;

import com.example.lab2.Model.Course;
import com.example.lab2.Service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.findAllCourses();
    }
    @PostMapping
    public void saveCourse(@RequestBody Course course){
        courseService.saveCourse(course);
    }
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable int id,@RequestBody Course course) throws Exception{
        return courseService.updateCourse(id,course);
    }
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id){
         courseService.deleteCourse(id);
    }
}
