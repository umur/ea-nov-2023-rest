package com.example.demo.service;


import com.example.demo.dto.CourseDTO;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<CourseDTO> getAllCourses();

    CourseDTO getCourseById(Long id);

    CourseDTO addCourse(CourseDTO courseDTO);

    CourseDTO updateCourse(Long id, CourseDTO courseDTO);

    void deleteCourse(Long id);

}
