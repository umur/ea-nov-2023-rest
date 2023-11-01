package com.example.lab2.Service;

import com.example.lab2.Model.Course;

import java.util.List;


public interface CourseService {
    List<Course> findAllCourses();
    void saveCourse(Course course);
    Course updateCourse(int id,Course course) throws Exception;
    void deleteCourse(int id);

}
