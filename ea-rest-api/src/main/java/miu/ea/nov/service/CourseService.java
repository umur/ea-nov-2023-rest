package miu.ea.nov.service;


import miu.ea.nov.payload.CourseDto;

import java.util.List;

public interface CourseService {
    CourseDto createCourse(long studentId, CourseDto courseDto);

    List<CourseDto> getCoursesByStudentId(long studentId);
}
