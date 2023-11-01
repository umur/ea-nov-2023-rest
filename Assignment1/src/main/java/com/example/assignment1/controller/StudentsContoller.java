package com.example.assignment1.controller;


import com.example.assignment1.domain.Course;
import com.example.assignment1.domain.Student;
import com.example.assignment1.dto.StudentDto;
import com.example.assignment1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentsContoller {


    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> getAllStudents(){
        return studentService.findAll();
    }
    @PostMapping
    public void addStudent(@RequestBody StudentDto stu){
        System.out.println("stu: "+stu);
        studentService.addStudent(stu);
    }

    @PutMapping("/{id}")
    public StudentDto updateStudent(@RequestBody StudentDto studentDto, @PathVariable int id){
        return studentService.updateStudent(id, studentDto);

    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){
            studentService.deleteStudent(id);

    }

    @GetMapping("/getStudent")
    public List<StudentDto> getStudentByMajor(@RequestParam String major){

        return studentService.getStudentByMajor(major);

    }

    @GetMapping("/getCoursesByStudentId")
    public List<StudentDto> getStudentByMajor(@RequestParam int id){

        return studentService.getCoursesByStudentId(id);
    }

}
