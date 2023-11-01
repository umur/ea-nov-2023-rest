package miu.ea.nov.controller;

import miu.ea.nov.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Combination of @Controller and @ResponseBody annotations
@RequestMapping("/api/students") // Base URL for REST API
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

} // End of student controller
