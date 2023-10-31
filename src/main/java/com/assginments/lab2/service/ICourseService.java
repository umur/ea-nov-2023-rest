package com.assginments.lab2.service;

import java.util.List;

import com.assginments.lab2.dto.CourseDto;
import com.assginments.lab2.dto.NewCourseDto;

public interface ICourseService {

    CourseDto getCourse(int id);

    CourseDto addCourse(NewCourseDto newCourseDto);

    List<CourseDto> getAllCourses();

    void removeCourse(int id);

    void updateCourse(int id, NewCourseDto updatedCourse);

    boolean doesExist(int id);

}