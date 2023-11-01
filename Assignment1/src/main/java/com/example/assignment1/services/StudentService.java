package com.example.assignment1.services;


import com.example.assignment1.dto.FullStudentDto;
import com.example.assignment1.entities.Course;
import com.example.assignment1.entities.Student;

import java.util.List;

public interface StudentService {

    List<FullStudentDto> getAllStudents();

    void saveStudent(Student student);

    void updateStudent(Long id, Student student);

    void deleteStudent(Long id);

    List<Student> getStudentsByMajor(String major);

    List<Course> getAllCourseById(Long id);


}
