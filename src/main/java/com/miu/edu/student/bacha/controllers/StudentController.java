package com.miu.edu.student.bacha.controllers;

import com.miu.edu.student.bacha.entities.Course;
import com.miu.edu.student.bacha.entities.Student;
import com.miu.edu.student.bacha.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {

        studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
      studentService.updateStudent(id,updatedStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
       studentService.deleteStudent(id);
    }

    @GetMapping("/byMajor")
    public List<Student> getStudentsByMajor(@RequestParam String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/courses/{studentId}")
    public List<Course> getCoursesByStudentId( @PathVariable int studentId) {
        return studentService.getCoursesByStudentId(studentId);
    }

}
