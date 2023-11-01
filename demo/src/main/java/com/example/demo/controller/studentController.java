package com.example.demo.controller;

import com.example.demo.dto.Coursedto;
import com.example.demo.dto.Studentdto;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class studentController {
    private final StudentService studentService;
    //CRUD
    //URL: abcd.com/students/ Method: Post
    @PostMapping
    public void createStudent(Studentdto studentdto) {
        studentService.save(studentdto);
    }

    //URL: abcd.com/students/ Method: Get
    @GetMapping
    List<Studentdto> findAll() {
        return studentService.findAll();

    }

    //URL: abcd.com/students/:id  Method: Get
    @GetMapping("{id}")
    Studentdto findByStudentId(@PathVariable int id) {
        return studentService.findByStudentId(id);
    }


    @PutMapping
    Studentdto update(Studentdto student) {
         studentService.update(student);
         return  student;
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        studentService.delete(id);

    }

    @GetMapping("/searchBy/{major}")
    List<Studentdto> getStudentsByMajor(@PathVariable String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    List<Coursedto> getCoursesByStudentId(int id) {
        return studentService.getCoursesByStudentId(id);
    }

}
