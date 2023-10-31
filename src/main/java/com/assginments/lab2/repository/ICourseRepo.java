package com.assginments.lab2.repository;

import java.util.List;

import com.assginments.lab2.entity.Course;

public interface ICourseRepo {

    Course addCourse(Course course);

    void removeCourse(int courseId);

    void updateCourse(Course updatedCourse);

    List<Course> getAllCourses();

    Course getCourse(int id);

    boolean doesExist(Course course);

    boolean doesExist(int courseId);

}