package com.example.assignment1.controllers;


import com.example.assignment1.dto.FullStudentDto;
import com.example.assignment1.entities.Course;
import com.example.assignment1.entities.Student;
import com.example.assignment1.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentControllers {


    private final StudentService studentService;

    @GetMapping
    public List<FullStudentDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public void SaveStudents(@RequestBody Student student){
        studentService.saveStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody Student student){
        studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

    @GetMapping("/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/course/{id}")
    public List<Course> getAllCourseByStudentId(@PathVariable Long id){
        return studentService.getAllCourseById(id);
    }

}
