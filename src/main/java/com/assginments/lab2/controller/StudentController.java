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
import com.assginments.lab2.service.CourseService;
import com.assginments.lab2.service.StudentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/students/")
public class StudentController {
    private final StudentService studentService;
    private final CourseService courseService;

    @GetMapping
    public List<StudentDto> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getAllBy")
    public List<StudentDto> getAllByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<List<CourseDto>> getStudentsCourses(@PathVariable int id) {
        if (!studentService.doesExist(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        var result = studentService.getAllStudentCourses(id);

        return new ResponseEntity<List<CourseDto>>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable int id) {
        if (!studentService.doesExist(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        var result = studentService.getStudent(id);
        return new ResponseEntity<StudentDto>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> add(@RequestBody NewStudentDto student) {
        studentService.addStudent(student);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        if (!studentService.doesExist(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.removeStudent(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable int id, @RequestBody NewStudentDto student) {
        if (!studentService.doesExist(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.updateStudent(id, student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/addCourse/{courseId}")
    public ResponseEntity<HttpStatus> addCourse(@PathVariable int id, @PathVariable int courseId) {
        if (!studentService.doesExist(id) || !courseService.doesExist(courseId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.addCourseToStudent(id, courseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}