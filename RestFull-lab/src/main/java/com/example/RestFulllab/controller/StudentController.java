package com.example.RestFulllab.controller;

import com.example.RestFulllab.dto.AddCourseDTO;
import com.example.RestFulllab.entity.Course;
import com.example.RestFulllab.entity.Student;
import com.example.RestFulllab.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getStudents()
    {
       return studentService.getall();
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id)
    {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public void saveStudent(@RequestBody Student student){
        studentService.save(student);
    }

    @PostMapping("/{id}")
    public void addCourses(@PathVariable int id , @RequestBody AddCourseDTO data)
    {
        System.out.println("OBJECTSSSS::::  "+data.getCourseId());
        studentService.addCourse(id , data.getCourseId());
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id , @RequestBody Student newStudent)
    {
        studentService.updateStudent(id,newStudent);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id)
    {
        studentService.delete(id);
    }
}
