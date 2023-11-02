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

    // Get student by {Id} REST API
    @GetMapping("/{id}")
    public ResponseEntity<StudentMinimalDto> getStudentById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    // Get student by {major} REST API
    @GetMapping("/major/{major}")
    public List<StudentMinimalDto> getStudentsByMajor(@PathVariable(name = "major") String major){
        return studentService.getStudentsByMajor(major);
    }

    // Update student by {id} REST API
    @PutMapping("/update/{id}")
    public ResponseEntity<StudentMinimalDto> updateStudent(@RequestBody StudentMinimalDto studentMinimalDto,
                                                           @PathVariable(name="id") long id) {

        StudentMinimalDto studentResponse = studentService.updateStudent(studentMinimalDto, id);

        return new ResponseEntity<>(studentResponse, HttpStatus.OK);

    }

    // delete Student by {id} REST API
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable(name = "id") long id){

        studentService.deleteStudentById(id);

        return new ResponseEntity<>("Student entity deleted successfully.", HttpStatus.OK);
    }

} // End of student controller
