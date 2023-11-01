package com.assignment.assignment1.service;

import com.assignment.assignment1.entity.Course;
import com.assignment.assignment1.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{
 private final CourseRepository courseRepository;


    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseByCourseId(int id) {
        return courseRepository.getCourseByCourseId(id);
    }

    @Override
    public void delete(Course course) {
courseRepository.delete(course);
    }
}
