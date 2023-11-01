package com.assignment.assignment1.controller;

import com.assignment.assignment1.entity.Course;
import com.assignment.assignment1.entity.Student;
import com.assignment.assignment1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Students")
@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping("")
    public List<Student>findAll(){

        return studentService.findAll();
    }
    @GetMapping("/major")
     public List<Student> getStudentsByMajor(@RequestParam String major){
         return studentService.getStudentsByMajor(major);
    }
    @PostMapping("")
    public void save(@RequestBody Student student){
        studentService.save(student);
    }
     @GetMapping("/{id}")
    public  List<Course>getCoursesByStudentId(@PathVariable int id){
        return studentService.getCoursesByStudentId(id);
     }

}
