package edu.ea.rest.service;


import edu.ea.rest.dto.FullCourseDto;
import edu.ea.rest.model.Course;

import java.util.List;

public interface CourseService {
    List<FullCourseDto> findAll();
    FullCourseDto findById(Integer id) throws Exception;
    FullCourseDto addCourse(FullCourseDto fullCourse);
    FullCourseDto update(Integer id, FullCourseDto fullCourse) throws Exception;
    Boolean delete (Integer courseId) throws Exception;
}
