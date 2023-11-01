package com.example.lab1.myapp.repository;

import com.example.lab1.myapp.model.Course;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    @Getter
    private static List<Course> courses = new ArrayList<>();

    public CourseRepo() {
        Course course1 = new Course(1, "CSE 101", "CSE101");
        Course course2 = new Course(2, "CSE 102", "CSE102");
        Course course3 = new Course(3, "CSE 103", "CSE103");
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
    }

    public static void save(Course course) {
        courses.add(course);
    }

    public static List<Course> findAll() {
        return courses;
    }

    public static Course findById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public static void delete(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                courses.remove(course);
            }
        }
    }

    public static void update(Integer id, Course course) {
        Course existingCourse = CourseRepo.findById(id);
        if (existingCourse != null) {
            existingCourse.setName(course.getName());
            existingCourse.setCode(course.getCode());
        }
    }

}
