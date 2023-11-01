package com.miu.lab2restfullwebservice.repository;

import com.miu.lab2restfullwebservice.entity.Course;
import com.miu.lab2restfullwebservice.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {
    private List<Course> courses = new ArrayList<>();

    public void create(Course course) {
        this.courses.add(course);
    }

    public void update(Course course) {
        this.courses.forEach(currentCourse -> {
            if (currentCourse.getId().equals(course.getId())) {
                currentCourse = course;
            }
        });
    }

    public Optional<Course> findById(Integer id) {
        return courses.stream().filter(student -> student.getId().equals(id)).findAny();
    }

    public boolean deleteById (int id) {
        boolean doesExist = courses.stream().anyMatch(course -> course.getId().equals(id));
        if (doesExist) {
            courses = courses.stream().filter(course -> !course.getId().equals(id)).collect(Collectors.toList());
        }
        return doesExist;
    }
    public boolean delete(Course course) {
        return deleteById(course.getId());
    }

}
