package com.assignment.assignment1.repository;

import com.assignment.assignment1.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CourseRepository {
    public  List<Course>courses= new ArrayList<>();



    public void save(Course course){
        courses.add(course);
    }
    public List<Course>findAll(){
        return courses;

    }
    public Course getCourseByCourseId(int id){
        for(Course course:courses){
            if(course.getId()==id)
                return course;
        }return null;
    }
    public void delete(Course course){
        for(Course course1:courses){
            if(course1==course)
                courses.remove(course);
        }
    }
}
