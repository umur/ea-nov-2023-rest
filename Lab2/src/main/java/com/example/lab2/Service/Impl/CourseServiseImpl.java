package com.example.lab2.Service.Impl;

import com.example.lab2.Model.Course;
import com.example.lab2.Repository.CourseRepo;
import com.example.lab2.Service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiseImpl implements CourseService {

    private final CourseRepo courseRepo;
    @Override
    public List<Course> findAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public void saveCourse(Course course) {
    courseRepo.save(course);
    }

    @Override
    public Course updateCourse(int id, Course course) throws Exception {
        Optional<Course> course1 = courseRepo.findById(id);
        if (course1.isPresent()) {
    Course newCourse=course1.get();
    newCourse.setName(course.getName());
    newCourse.setCode(course.getCode());
    return newCourse;
        }else {throw new Exception("The course Not Found");}
    }

    @Override
    public void deleteCourse(int id) {
    courseRepo.deleteById(id);
    }


}
