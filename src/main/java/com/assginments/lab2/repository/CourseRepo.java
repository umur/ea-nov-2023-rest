package com.assginments.lab2.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.assginments.lab2.entity.Course;

@Repository
public class CourseRepo {
    private List<Course> courses = new ArrayList<>();

    public Course addCourse(Course course) {
        course.setId(courses.size() + 1);
        courses.add(course);

        return course;
    }

    public void removeCourse(int courseId) {
        var course = getCourse(courseId);
        course.setDeleted(true);
        // courses = courses.stream().filter(x -> x.getId() != courseId).toList();
    }

    public void updateCourse(Course updatedCourse) {
        var course = getCourse(updatedCourse.getId());

        course.setName(updatedCourse.getName());
        course.setCode(updatedCourse.getCode());
    }

    public List<Course> getAllCourses() {
        return courses.stream().filter(c -> !c.isDeleted()).toList();
    }

    public Course getCourse(int id) {
        return courses.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    public boolean doesExist(Course course) {
        return getCourse(course.getId()) != null;
    }

    public boolean doesExist(int courseId) {
        return getCourse(courseId) != null;
    }

}
