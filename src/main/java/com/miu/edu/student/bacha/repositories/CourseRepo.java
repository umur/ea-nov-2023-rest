package com.miu.edu.student.bacha.repositories;

import com.miu.edu.student.bacha.entities.Course;

import java.util.List;
public interface CourseRepo{
    List<Course> findAll();
    Course findById(int id);
    void save(Course course);
    void deleteById(int id);
}
