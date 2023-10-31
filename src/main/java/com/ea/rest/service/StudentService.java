package com.ea.rest.service;

import com.ea.rest.model.Course;
import com.ea.rest.model.Student;

import java.util.List;

public interface StudentService {
    void create(Student student);

    List<Student> findAll();

    void update(Student student);

    Student getStudent(Long id);

    void delete(Long id);
    List<Course> getCoursesByStudentId(Long id);

    List<Student> getStudentsByMajor(String major);
}
