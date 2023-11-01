package miu.ea.nov.controller;

import miu.ea.nov.service.StudentServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Combination of @Controller and @ResponseBody annotations
@RequestMapping("/api/students") // Base URL for REST API
public class StudentController {
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    /*
    Implement CRUD operations for the domains.
    Implement getStudentsByMajor(String major)
    Returns all students majoring major.*/

} // End of student controller
