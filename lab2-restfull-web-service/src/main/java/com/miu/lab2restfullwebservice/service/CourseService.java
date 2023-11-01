package com.miu.lab2restfullwebservice.service;

import com.miu.lab2restfullwebservice.entity.Course;

import java.util.List;

public interface CourseService {
    void create();
    List<Course> findAll();
    Course findById(int id);
    Course update(Course course);

}
