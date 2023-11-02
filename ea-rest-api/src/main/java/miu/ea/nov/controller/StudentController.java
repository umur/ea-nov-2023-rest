package miu.ea.nov.controller;

import miu.ea.nov.payload.StudentFullDto;
import miu.ea.nov.payload.StudentMinimalDto;
import miu.ea.nov.service.impl.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/create")
    public ResponseEntity<StudentFullDto> createStudent(@RequestBody StudentFullDto studentFullDto){
        return new ResponseEntity<>(studentService.createStudent(studentFullDto), HttpStatus.CREATED);
    }

    // Get all students REST API
    @GetMapping
    public List<StudentMinimalDto> getAllStudents(){
        return studentService.findAllStudents();
    }

} // End of student controller
