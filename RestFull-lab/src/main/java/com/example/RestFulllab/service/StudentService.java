package com.example.RestFulllab.service;

import com.example.RestFulllab.entity.Course;
import com.example.RestFulllab.entity.Student;

import java.util.List;

public interface StudentService {
    void save(Student student);
    List<Student> getall();
    Student getStudentById(int id);
    void addCourse(int id, int courseId);

    Student updateStudent(int id , Student newStudent);
    void delete(int id);

    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int id);

}
