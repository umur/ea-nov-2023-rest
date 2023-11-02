package miu.ea.nov.service;


import miu.ea.nov.payload.CourseDto;

public interface CourseService {
    CourseDto createCourse(long studentId, CourseDto courseDto);
}
