package com.rest.services;

import com.rest.domains.entities.Course;

import java.util.List;

public interface CourseService {
    void save(Course c);
    Course getByID(int id);
    List<Course> getAll();
    void update(int id, Course course);
    void delete(int id);
};
