package miu.ea.nov.service;


import miu.ea.nov.payload.CourseDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> findAll();
}
