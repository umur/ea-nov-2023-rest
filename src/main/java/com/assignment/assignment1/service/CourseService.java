package com.assignment.assignment1.service;

import com.assignment.assignment1.domain.Course;
import com.assignment.assignment1.dto.FullCourseDto;

import java.util.List;

public interface CourseService {
    public FullCourseDto save(FullCourseDto student);
    public List<FullCourseDto> findAll();
    public FullCourseDto findById(int id);
    public List<FullCourseDto> getCoursesByStudentId(int id);
    public FullCourseDto delete(int id);
    public FullCourseDto put(int id, FullCourseDto courseDto);

}
