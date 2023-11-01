package com.assignment.assignment1.controller;// http://localhost:8080/courses

import com.assignment.assignment1.dto.FullCourseDto;
import com.assignment.assignment1.service.CourseService;
import com.assignment.assignment1.service.impl.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseServiceImpl courseService;

    @GetMapping
    public List<FullCourseDto> findAll() {
        return courseService.findAll();
    }

    // http://localhost:8080/courses?major=compro
    @GetMapping("/searchByStudentId")
    public List<FullCourseDto> getAllByStudentId(@RequestParam int studentId) {
        return courseService.getCoursesByStudentId(studentId);
    }

    @GetMapping("/{id}")
    public FullCourseDto findById(@PathVariable int id) {
        return courseService.findById(id);
    }

    @PostMapping
    public FullCourseDto save(@RequestBody FullCourseDto courseDto) {
        return courseService.save(courseDto);
    }

    @DeleteMapping("/{id}")
    public FullCourseDto deleteById(@PathVariable int id) {
        return courseService.delete(id);
    }

    @PutMapping("/{id}")
    public FullCourseDto update(@RequestBody FullCourseDto courseDto, @PathVariable int id) {
        return courseService.put(id, courseDto);
    }
}
