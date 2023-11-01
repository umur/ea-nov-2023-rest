package com.example.lab1.myapp.service;

import com.example.lab1.myapp.dto.CourseDto;
import com.example.lab1.myapp.dto.StudentDto;
import com.example.lab1.myapp.model.Course;
import com.example.lab1.myapp.model.Student;

import java.util.List;

public interface StudentService {
    void save(Student student);
    List<StudentDto> getAll();

    StudentDto getById(Integer id);

    List<StudentDto> getStudentsByMajor(String major);
    List<CourseDto> getCourseByStudentId(int id);
    void delete(Integer id);
    void update(Integer id, StudentDto student);

}
