package com.example.RestFulllab.service.implementation;

import com.example.RestFulllab.entity.Course;
import com.example.RestFulllab.repository.CourseRepo;
import com.example.RestFulllab.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;
    @Override
    public void save(Course course) {
        courseRepo.save(course);
    }

    @Override
    public List<Course> getall() {
        return courseRepo.getall();
    }

    @Override
    public Course getCourseById(int id) {
        Optional<Course> c1= courseRepo.getCourseById(id);
        if(c1.isPresent())
        {
            return c1.get();
        }
        throw new RuntimeException("No Course Found For This ID");

    }
}
