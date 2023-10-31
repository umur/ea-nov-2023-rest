package com.example.assignment1.controller;


import com.example.assignment1.domain.Course;
import com.example.assignment1.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsContoller {

    @GetMapping
    public String getStudents(){

//        Student stu = new Student(1, "firstName", "Lastname", "email", "email@g.com", 3.25,"major 1",   );


        return "stu";
    }
    @PostMapping
    public Student addStudent(@RequestBody Student stu){
        List<Course> courses = new ArrayList<>();
        Student students = new Student(1, "firstName", "Lastname", "email", "email@g.com", 3.25,"major 1",courses  );
        return students;
    }

}
