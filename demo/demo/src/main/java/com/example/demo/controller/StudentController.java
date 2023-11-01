package com.example.demo.controller;


import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/students")
//@NoArgsConstructor()
@RequiredArgsConstructor
public class StudentController {
    //private final CourseService courseService;
    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> getStudents(){
        return studentService.finAll();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.save(student);
    }

    @PutMapping("/{studentId}")
    public void editStudent(@PathVariable int studentId, @RequestBody Student student){
        studentService.editStudent(studentId, student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable int studentId){
        studentService.deleteStudent(studentId);
    }

    @PostMapping("/add/{studentId}")
    public void addCourse(@PathVariable int studentId, @RequestBody Course course){
        studentService.addCourse(studentId, course);
    }

    @GetMapping("/{studentId}/courses")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int studentId) {
        return studentService.getCoursesByStudentId(studentId);
    }

    @GetMapping("/search")
    public List<StudentDto> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }
}
