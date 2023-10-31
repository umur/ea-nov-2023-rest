package com.assginments.lab2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.assginments.lab2.dto.CourseDto;
import com.assginments.lab2.dto.NewCourseDto;
import com.assginments.lab2.service.CourseService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/courses/")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<CourseDto> getAll() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseDto getById(@PathVariable int id) {
        return courseService.getCourse(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addCourse(@RequestBody NewCourseDto course) {
        courseService.addCourse(course);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable int id) {
        courseService.removeCourse(id);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody NewCourseDto course) {
        courseService.updateCourse(id, course);
    }
}