package com.assignment.assignment1.repository;

import com.assignment.assignment1.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepo {

    private static List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course(1,"mpp","410", false),
            new Course(2, "wap", "472", false),
            new Course(3, "ea", "510", false),
            new Course(4, "algo", "490", false)
    ));
    public Course save(Course course) {
        courses.add(course);
        return course;
    }

    public List<Course> findAll() {
        return courses.stream()
                .filter(c -> !c.isDeleted())
                .toList();
    }

    public Optional<Course> findById(int id) {
        return courses.stream()
                .filter(c -> c.getId() == id)
                .filter(c -> !c.isDeleted())
                .findFirst();
    }

    public Optional<Course> delete(int id) {
        Optional<Course> courseOptional = findById(id);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            course.setDeleted(true);
        }
        return courseOptional;
    }

    public Optional<Course> put(int id, Course updatedCourse) {
        Optional<Course> courseOptional = findById(id);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            course.setId(updatedCourse.getId());
            course.setName(updatedCourse.getName());
            course.setCode(updatedCourse.getCode());
        }
        return courseOptional;
    }
}
