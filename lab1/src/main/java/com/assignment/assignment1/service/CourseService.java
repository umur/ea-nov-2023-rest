package com.assignment.assignment1.service;

import com.assignment.assignment1.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    void save(Course course);
    List<Course> findAll();
    Course getCourseByCourseId(int id);
    void delete(Course course);
}
