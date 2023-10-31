package com.ea.rest.service.impl;

import com.ea.rest.model.Course;
import com.ea.rest.repository.CourseRepository;
import com.ea.rest.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepo;

    public void create(Course course) {
        if(course.getName() == null || course.getName().length() < 5) {
            throw new RuntimeException("Course name must be at least 5 characters");
        }
        if(course.getCode() == null || course.getCode().length() < 3) {
            throw new RuntimeException("Course code must be at least 3 characters");
        }

        courseRepo.create(course);
    }

    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public void update(Course course) {
        if(course.getName() == null || course.getName().length() < 5) {
            throw new RuntimeException("Course name must be at least 5 characters");
        }
        if(course.getCode() == null || course.getCode().length() < 3) {
            throw new RuntimeException("Course code must be at least 3 characters");
        }
        courseRepo.update(course);
    }

    @Override
    public Course getCourse(Long id) {
        return courseRepo.getCourse(id);
    }

    @Override
    public void delete(Long id) {
        courseRepo.delete(id);
    }
}
