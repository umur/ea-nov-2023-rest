package ea.lab2.lab2.repository;

import ea.lab2.lab2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private static final List<Course> courses = new ArrayList<>();

    public void addCourse(Course course){
        courses.add(course);
    }

    public List<Course> findAll(){
        return courses;
    }
}
