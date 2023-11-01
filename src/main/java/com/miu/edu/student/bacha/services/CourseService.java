package com.miu.edu.student.bacha.services;

import com.miu.edu.student.bacha.entities.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<Course> getAllCourses();

    Course getCourseById(int id);

    void addCourse(Course course);

    void updateCourse(int id, Course updatedCourse);

    void deleteCourse(int id);
}
