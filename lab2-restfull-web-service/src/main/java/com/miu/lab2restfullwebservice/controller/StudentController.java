package com.miu.lab2restfullwebservice.controller;

import com.miu.lab2restfullwebservice.common.Converter;
import com.miu.lab2restfullwebservice.dto.ApiResponse;
import com.miu.lab2restfullwebservice.dto.CourseDto;
import com.miu.lab2restfullwebservice.dto.StudentDto;
import com.miu.lab2restfullwebservice.entity.Course;
import com.miu.lab2restfullwebservice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final Converter converter;

    @GetMapping
    ApiResponse<List<StudentDto>, String> getAllStudents() {
        return converter.generateResponse(studentService.findAll(), "There are no students enrolled in this session");
    }

    @GetMapping("/:id")
    ApiResponse<StudentDto, String> findById(@PathVariable Integer id) {
        return converter.generateResponse(studentService.findById(id).get(), "No student record found with id : " + id);
    }

    @GetMapping("/:email")
    ApiResponse<StudentDto, String> findByEmail(@PathVariable String email) {
        return converter.generateResponse(studentService.findByEmail(email).get(), "No student record found with the email : " + email);
    }
    @PostMapping
    ApiResponse<String, String> createStudent(@RequestBody StudentDto student) {
        studentService.save(student);
        return converter.generateResponse("The student is Successfully saved", null);
    }

    @PutMapping
    ApiResponse<String, String> updateStudent(@RequestBody StudentDto student) {
        studentService.save(student);
        return converter.generateResponse("The student record is Successfully updated", null);
    }

    @DeleteMapping("/:id")
    ApiResponse<String, String> delete(@PathVariable int studentId) {
        String errors = null;
        String success = null;
        try {
            studentService.delete(studentId);
            success = "The student record is Successfully updated";
        } catch (RuntimeException e) {
            errors = e.getMessage();
        }
        return converter.generateResponse(success, errors);
    }

    @GetMapping("?code")
    ApiResponse<List<StudentDto>, String> getStudentsByMajor(@RequestParam String code) {
        return converter.generateResponse(studentService.getStudentsByMajor(code), "No Student is found with this course code : " + code);
    }

    @GetMapping("/:studentId/courses")
    ApiResponse<List<CourseDto>, String> getCoursesByStudentId(@PathVariable Integer studentId) {
        return converter.generateResponse(studentService.getCoursesByStudentId(studentId), "No courses found for this student with id: " + studentId);
    }
}
