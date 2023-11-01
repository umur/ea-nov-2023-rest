package com.example.demo.controller;

import com.example.demo.dto.CourseDTO;
import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
@Validated
public class studentsController {

    final StudentService studentService;

    @GetMapping()
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/searchByMajor")
    public List<StudentDTO> findAllByColor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDTO> getCoursesByStudentId(@PathVariable Long id) {
        return studentService.getCoursesByStudentId(id);
    }

    @GetMapping("/{id}")
    public StudentDTO findById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping()
    public StudentDTO save(@RequestBody StudentDTO student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public StudentDTO update(@PathVariable Long id, @RequestBody StudentDTO student) {
        return studentService.updateStudent(id, student);
    }

}
