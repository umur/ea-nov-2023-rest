package com.assginments.lab2.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.assginments.lab2.dto.CourseDto;
import com.assginments.lab2.dto.NewCourseDto;
import com.assginments.lab2.entity.Course;
import com.assginments.lab2.repository.ICourseRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CourseService implements ICourseService {
    private final ICourseRepo courseRepo;
    private final ModelMapper mapper;

    @Override
    public CourseDto getCourse(int id) {
        var course = courseRepo.getCourse(id);
        return mapper.map(course, CourseDto.class);
    }

    @Override
    public CourseDto addCourse(NewCourseDto newCourseDto) {
        var course = mapper.map(newCourseDto, Course.class);
        var result = courseRepo.addCourse(course);

        return mapper.map(result, CourseDto.class);
    }

    @Override
    public List<CourseDto> getAllCourses() {
        var courses = courseRepo.getAllCourses();
        List<CourseDto> result = new ArrayList<>();

        courses.forEach(course -> {
            CourseDto cdto = mapper.map(course, CourseDto.class);
            result.add(cdto);
        });
        return result;
    }

    @Override
    public void removeCourse(int id) {
        if (courseRepo.doesExist(id)) {
            courseRepo.removeCourse(id);
        }
    }

    @Override
    public void updateCourse(int id, NewCourseDto updatedCourse) {
        if (courseRepo.doesExist(id)) {
            var course = mapper.map(updatedCourse, Course.class);
            course.setId(id);
            courseRepo.updateCourse(course);
        }

    }

    @Override
    public boolean doesExist(int id) {
        return courseRepo.doesExist(id);
    }

}
