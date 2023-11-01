package com.rest.controllers;

import com.rest.domains.entities.Course;
import com.rest.domains.entities.Student;
import com.rest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    };
    @PostMapping
    public void save(@RequestBody Student s){
        studentService.save(s);
    };

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    };

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id){
        return studentService.getById(id);
    };

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Student s){
        studentService.update(id, s);
    };

    @GetMapping("/filterByMajor/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
    };

};
