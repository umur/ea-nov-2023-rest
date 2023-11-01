package com.example.demo.service.impl;

import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Service
@RestController
public class CourseService implements com.example.demo.service.CourseService {
    private final CourseRepo courseRepo;


    @Override
    public List<CourseDto> finAll() {
        return courseRepo.getAll();
    }

    @Override
    public void save(Course course) {
        courseRepo.save(course);
    }

    @Override
    public void edit(int courseId, Course course) {
        courseRepo.edit(courseId, course.getName(), course.getCode());
    }

    @Override
    public void deleteCourse(int courseId) {
        courseRepo.deleteCourse(courseId);
    }
}