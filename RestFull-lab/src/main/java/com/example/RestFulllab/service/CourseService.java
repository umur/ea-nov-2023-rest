package com.example.RestFulllab.service;

import com.example.RestFulllab.entity.Course;

import java.util.List;

public interface CourseService{
    void save(Course course);

    List<Course> getall();
    Course getCourseById(int id);
}
