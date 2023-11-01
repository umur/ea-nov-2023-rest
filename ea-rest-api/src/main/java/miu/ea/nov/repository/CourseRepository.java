package miu.ea.nov.repository;

import miu.ea.nov.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    // Hold data in array lists.
    private static final List<Course> courses = new ArrayList<Course>();
    public List<Course> courseList() {
        courses.add(new Course(1L, "AI", "CS589"));
        courses.add(new Course(2L, "SA", "CS590"));
        courses.add(new Course(3L, "EA", "CS544"));
        courses.add(new Course(4L, "Algo", "CS472"));
        return courses;
    }

} // End of course repository class
