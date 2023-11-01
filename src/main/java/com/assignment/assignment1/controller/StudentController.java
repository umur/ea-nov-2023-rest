package com.assignment.assignment1.controller;// http://localhost:8080/students

import com.assignment.assignment1.dto.FullStudentDto;
import com.assignment.assignment1.dto.PostStudentDto;
import com.assignment.assignment1.service.StudentService;
import com.assignment.assignment1.service.impl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentServiceImpl studentService;

    @GetMapping
    public List<FullStudentDto> findAll() {
        return studentService.findAll();
    }

    // http://localhost:8080/students?major=compro
    @GetMapping("/searchByMajor")
    public List<FullStudentDto> getAllByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}")
    public FullStudentDto findById(@PathVariable int id) {
        return studentService.findById(id);
    }

    @PostMapping
    public FullStudentDto save(@RequestBody PostStudentDto studentDto) {
        return studentService.save(studentDto);
    }

    @DeleteMapping("/{id}")
    public FullStudentDto deleteById(@PathVariable int id) {
        return studentService.delete(id);
    }

    @PutMapping("/{id}")
    public FullStudentDto update(@RequestBody PostStudentDto studentDto, @PathVariable int id) {
        return studentService.put(id, studentDto);
    }
}
