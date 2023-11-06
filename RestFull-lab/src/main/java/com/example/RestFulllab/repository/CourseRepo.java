package com.example.RestFulllab.repository;

import com.example.RestFulllab.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepo {

    private static List<Course> courses = new ArrayList<>();

    public void save(Course course)
    {
     courses.add(course);
     System.out.println("Courses : "+ courses );
    }

    public List<Course> getall()
    {
        return courses;
    }

    public Optional<Course> getCourseById(int id){
        return courses.stream().filter(course -> course.getId()==id).findFirst();
    }
}
