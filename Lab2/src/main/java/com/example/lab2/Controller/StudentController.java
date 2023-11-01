package com.example.lab2.Controller;


import com.example.lab2.DTO.SimpleStudentDto;
import com.example.lab2.Model.Course;
import com.example.lab2.Model.Student;
import com.example.lab2.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.findAllStudents();
    }
    @PostMapping
    public void saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id,@RequestBody Student student) throws Exception{
        return studentService.updateStudent(id,student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }

    @GetMapping("/{major}")
    public List<SimpleStudentDto> getStudentsByMajor(@PathVariable String major)
    {
       return studentService.getStudentsByMajor(major);
    }
    @GetMapping("/studentCourses/{id}")
    public List<Course> getStudentCoursesById(@PathVariable int id){
        return studentService.getCoursesByStudentId(id);
    }
}
