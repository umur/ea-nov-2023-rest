package com.assignment.assignment1.service;

import com.assignment.assignment1.entity.Course;
import com.assignment.assignment1.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    void save(Student student);
    List<Student>findAll();

    void delete(int id);
    void update(Student student);
    List<Student>getStudentsByMajor(String major);
    List<Course>getCoursesByStudentId(int studentId);
}
