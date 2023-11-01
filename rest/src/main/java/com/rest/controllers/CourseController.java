package com.rest.controllers;

import com.rest.domains.entities.Course;
import com.rest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    CourseService courseService;

    @Autowired
    public  CourseController(CourseService courseService){
        this.courseService = courseService;
    };

    @PostMapping
    public void save(@RequestBody Course c){
        courseService.save(c);
    };

    @GetMapping
    public List<Course> getAll(){
        return courseService.getAll();
    };

    @GetMapping("/{id}")
    public Course getById(@PathVariable int id){
        return courseService.getByID(id);
    };

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Course c){
        courseService.update(id, c);
    };

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        courseService.delete(id);
    };
};
