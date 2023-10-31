package com.ea.rest.controller;

import com.ea.rest.model.Course;
import com.ea.rest.model.Student;
import com.ea.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public void create(@RequestBody Student student) {
        studentService.create(student);
    }

    @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getAll() {
        return studentService.findAll();
    }

    @GetMapping("/filterStudentsByMajor")
    public List<Student> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/getCoursesByStudentId")
    public List<Course> getCoursesByStudentId(@RequestParam Long id) {
        return studentService.getCoursesByStudentId(id);
    }

    @GetMapping("/getAllCoursesOfStudent")
    public List<Course> getAllCoursesOfStudent(@RequestParam Long id) {
        return studentService.getCoursesByStudentId(id);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @PutMapping
    public void update(@RequestBody Student student) {
        studentService.update(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}