package com.assignment.assignment1.controller;

import com.assignment.assignment1.entity.Course;
import com.assignment.assignment1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final  CourseService courseService;




    @GetMapping("")
    public List<Course> findAll(){
        return courseService.findAll();
    }



}
