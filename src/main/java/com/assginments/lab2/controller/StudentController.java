package com.assginments.lab2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assginments.lab2.dto.CourseDto;
import com.assginments.lab2.dto.NewStudentDto;
import com.assginments.lab2.dto.StudentDto;
import com.assginments.lab2.service.StudentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/students/")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getAllBy")
    public List<StudentDto> getAllByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDto> getAllByMajor(@PathVariable int id) {
        return studentService.getAllStudentCourses(id);
    }

    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> add(@RequestBody NewStudentDto student) {
        studentService.addStudent(student);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        studentService.removeStudent(id);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody NewStudentDto student) {
        studentService.updateStudent(id, student);
    }

    // @PostMapping("/{id}/courses")
    // public void addCourseToStudent(@PathVariable int id, @RequestBody
    // NewCourseDto course) {
    // studentService.addCourseToStudent(id, course);
    // }
    @PutMapping("/{id}/addCourse/{courseId}")
    public void addCourse(@PathVariable int id, @PathVariable int courseId) {
        studentService.addCourseToStudent(id, courseId);
    }
}