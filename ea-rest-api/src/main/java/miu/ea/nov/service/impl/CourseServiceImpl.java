package miu.ea.nov.service.impl;

import miu.ea.nov.entity.Course;
import miu.ea.nov.entity.Student;
import miu.ea.nov.payload.CourseDto;
import miu.ea.nov.payload.StudentFullDto;
import miu.ea.nov.repository.CourseRepository;
import miu.ea.nov.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        // Convert DTO to Entity
        Course course = new Course();
        course.setId(courseDto.getId());
        course.setName(courseDto.getName());
        course.setCode(courseDto.getCode());
        Course newCourse = courseRepository.save(course);

        // Convert Entity to DTO
        CourseDto courseResponse = new CourseDto();
        courseResponse.setId(newCourse.getId());
        courseResponse.setName(newCourse.getName());
        courseResponse.setCode(newCourse.getCode());
        return courseResponse;
    }
}
