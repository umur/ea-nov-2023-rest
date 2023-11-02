package miu.ea.nov.repository;

import miu.ea.nov.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    // Hold data in array lists.
    private static final List<Course> courses = new ArrayList<Course>();
    private static final List<Course> newCourses = new ArrayList<Course>();
    static List<Course> comproCoursesList() {
        courses.add(new Course(1L, "AI", "CS589", StudentRepository.student1));
        courses.add(new Course(2L, "SA", "CS590", StudentRepository.student2));
        courses.add(new Course(3L, "EA", "CS544", StudentRepository.student3));
        courses.add(new Course(4L, "Algo", "CS472", StudentRepository.student4));
        return courses;
    }

    public Course save(Course course){
        newCourses.add(course);
        return course;
    }

} // End of course repository class
