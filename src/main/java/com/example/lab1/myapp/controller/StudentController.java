package com.example.lab1.myapp.controller;

import com.example.lab1.myapp.dto.StudentDto;
import com.example.lab1.myapp.service.StudentService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> getAllStudents() {
        System.out.println("get all students");
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Integer id) {
        System.out.println("get student by id");
        return studentService.getById(id);
    }

    @GetMapping("/searchByMajor")
    public List<StudentDto> getStudentsByMajor(String major) {
        return studentService.getStudentsByMajor(major);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Integer id) {
        System.out.println("delete student by id");
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public void updateStudentById(@PathVariable Integer id, @RequestBody StudentDto student) {
        System.out.println("update student by id");
        studentService.update(id, student);
    }

}
