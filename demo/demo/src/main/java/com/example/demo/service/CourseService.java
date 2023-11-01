package com.example.demo.service;


import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    public List<CourseDto> finAll();

    public void save(Course course);
    public void edit(int courseId, Course course);

    public void deleteCourse(int courseId);
}
