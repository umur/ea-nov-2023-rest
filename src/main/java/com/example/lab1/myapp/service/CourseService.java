package com.example.lab1.myapp.service;

import com.example.lab1.myapp.dto.CourseDto;
import com.example.lab1.myapp.model.Course;

import java.util.List;

public interface CourseService {
    void save(Course course);

    List<CourseDto> findAll();

    CourseDto findById(Integer id);

    void delete(Integer id);

    void update(Integer id, CourseDto course);
}
