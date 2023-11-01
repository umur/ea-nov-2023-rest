package com.miu.edu.student.bacha.services;

import com.miu.edu.student.bacha.entities.Course;
import com.miu.edu.student.bacha.repositories.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{
    private final  CourseRepo courseRepo;
    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepo.findById(id);
    }

    @Override
    public void addCourse(Course course) {
        courseRepo.save(course);
    }

    @Override
    public void updateCourse(int id, Course updatedCourse) {
        Course course = getCourseById(id);
        if(course!=null){
            course.setId(updatedCourse.getId());
            course.setName(updatedCourse.getName());
            course.setCode(updatedCourse.getName());
        }
        else throw new RuntimeException("""
                No course with id ${id} exists""");
    }

    @Override
    public void deleteCourse(int id) {
        courseRepo.deleteById(id);
    }
}
