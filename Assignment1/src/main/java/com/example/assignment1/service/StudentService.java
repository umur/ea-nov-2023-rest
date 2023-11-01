package com.example.assignment1.service;

import com.example.assignment1.domain.Student;
import com.example.assignment1.dto.StudentDto;
import com.example.assignment1.repository.StudentRepository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface StudentService {

    List<StudentDto> findAll();

    void addStudent( StudentDto studentDto);

    StudentDto updateStudent(int id,StudentDto studentDto);
    public void deleteStudent(int id);

    List<StudentDto> getStudentByMajor(String major);
    List<StudentDto> getCoursesByStudentId(int studentId);
}
