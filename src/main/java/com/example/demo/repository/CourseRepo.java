package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepo {

    static List<Course> courses = new ArrayList<>();

    CourseRepo() {
        Course course = new Course();
        course.setId(1L);
        course.setName("Java");
        course.setCode("CS101");

        Course course2 = new Course();
        course2.setId(2L);
        course2.setName("Python");
        course2.setCode("CS102");

        Course course3 = new Course();
        course3.setId(3L);
        course3.setName("C++");
        course3.setCode("CS103");

        courses.add(course);
        courses.add(course2);
        courses.add(course3);
    }

    // save
    public Course save(Course course) {
        courses.add(course);
        return course;
    }

    public Course update(Course course) {
        for (Course c : courses) {
            if (c.getId() == course.getId()) {
                c.setName(course.getName());
                c.setCode(course.getCode());
            }
        }
        return course;
    }

    public Optional<Course> findById(Long id) {
        return courses.stream().filter(course -> course.getId() == id).findFirst();
    }

    public List<Course> findAll() {
        return courses;
    }

}
