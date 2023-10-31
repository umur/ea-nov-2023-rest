package com.assginments.lab2.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.assginments.lab2.entity.Course;

@Repository
public class CourseRepo implements ICourseRepo {
    private List<Course> courses = new ArrayList<>();

    @Override
    public Course addCourse(Course course) {
        course.setId(courses.size() + 1);
        courses.add(course);

        return course;
    }

    @Override
    public void removeCourse(int courseId) {
        var course = getCourse(courseId);
        course.setDeleted(true);
        // courses = courses.stream().filter(x -> x.getId() != courseId).toList();
    }

    @Override
    public void updateCourse(Course updatedCourse) {
        var course = getCourse(updatedCourse.getId());

        course.setName(updatedCourse.getName());
        course.setCode(updatedCourse.getCode());
    }

    @Override
    public List<Course> getAllCourses() {
        return courses.stream().filter(c -> !c.isDeleted()).toList();
    }

    @Override
    public Course getCourse(int id) {
        return courses.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean doesExist(Course course) {
        return getCourse(course.getId()) != null;
    }

    @Override
    public boolean doesExist(int courseId) {
        return getCourse(courseId) != null;
    }

}
