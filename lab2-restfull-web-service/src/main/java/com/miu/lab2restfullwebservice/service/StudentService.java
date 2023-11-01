package com.miu.lab2restfullwebservice.service;

import com.miu.lab2restfullwebservice.dto.CourseDto;
import com.miu.lab2restfullwebservice.dto.StudentDto;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentDto> findAll();
    StudentDto save(StudentDto student);
    Optional<StudentDto> findById(Integer id);
    Optional<StudentDto> findByEmail(String email);
    void delete(int studentId);
    List<StudentDto> getStudentsByMajor(String major);
    List<CourseDto> getCoursesByStudentId(int studentId);
}
