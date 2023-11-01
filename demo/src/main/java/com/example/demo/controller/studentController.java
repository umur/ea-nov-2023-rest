package com.example.demo.controller;

import com.example.demo.dto.Coursedto;
import com.example.demo.dto.Studentdto;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    }

    //URL: abcd.com/students/:id  Method: Get
    Studentdto findByStudentId(int id) {

    }

    Studentdto update(Student student) {

    }

    void delete(int id) {

    }

    List<Studentdto> getStudentsByMajor(String major) {

    }

    List<Coursedto> getCoursesByStudentId(int id) {

    }

}
