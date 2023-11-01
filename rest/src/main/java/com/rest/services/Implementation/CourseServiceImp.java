package com.rest.services.Implementation;

import com.rest.domains.entities.Course;
import com.rest.repositories.CourseRepo;
import com.rest.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {

    CourseRepo courseRepo;

    @Autowired
    public CourseServiceImp(CourseRepo courseRepo){
        this.courseRepo = courseRepo;
    };

    @Override
    public void save(Course c) {
        courseRepo.save(c);
    };

    @Override
    public Course getByID(int id) {
        return courseRepo.getById(id);
    };

    @Override
    public List<Course> getAll() {
        return courseRepo.getAll();
    };

    @Override
    public void update(int id, Course course) {
        courseRepo.update(id, course);
    };

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    };
};
