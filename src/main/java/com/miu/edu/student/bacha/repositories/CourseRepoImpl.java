package com.miu.edu.student.bacha.repositories;

import com.miu.edu.student.bacha.entities.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepoImpl implements CourseRepo{
    static List<Course> courses = new ArrayList<>();
    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public Course findById(int id) {
        return courses
                .stream()
                .filter(course -> course.getId()==id)
                .findFirst()
                .orElseThrow(()->new RuntimeException("""
                        No course with id: ${id} exists."""));
    }

    @Override
    public void save(Course course) {
        courses.add(course);
    }

    @Override
    public void deleteById(int id) {
        courses.remove(findById(id));
    }
}
