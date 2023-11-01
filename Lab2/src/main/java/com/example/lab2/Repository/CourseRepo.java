package com.example.lab2.Repository;

import com.example.lab2.Model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {
    private static List<Course> courses = new ArrayList<>();

    public void save(Course course) {
        courses.add(course);
    }

    public List<Course> findAll() {
        return courses;
    }
    public Optional<Course> findById(int id) {
      Optional<Course> course=courses.stream().filter(c->c.getId()==id).findFirst();

            return course;


    }
    public void deleteById(int id){
        List<Course> newCourses=courses.stream().filter(c->c.getId()!=id).collect(Collectors.toList());
        courses=newCourses;
    }
}
