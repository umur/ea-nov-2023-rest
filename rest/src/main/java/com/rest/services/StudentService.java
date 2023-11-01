package com.rest.services;

import com.rest.domains.entities.Course;
import com.rest.domains.entities.Student;

import java.util.List;

public interface StudentService {
    void save(Student s);
    Student getById(int id);
    List<Student> getAll();
    void update(int id,Student student);
    void delete(int id);
    List<Student> getStudentsByMajor(String major);
};
