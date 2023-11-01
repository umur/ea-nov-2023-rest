package miu.ea.nov.repository;

import miu.ea.nov.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    // Hold data in array lists.
    private static final List<Course> comproCourses = new ArrayList<Course>();
    private static final List<Course> mbaCourses = new ArrayList<Course>();
    static List<Course> comproCoursesList() {
        comproCourses.add(new Course(1L, "AI", "CS589"));
        comproCourses.add(new Course(2L, "SA", "CS590"));
        comproCourses.add(new Course(3L, "EA", "CS544"));
        comproCourses.add(new Course(4L, "Algo", "CS472"));
        return comproCourses;
    }
    static List<Course> mbaCoursesList() {
        mbaCourses.add(new Course(1L, "SAP", "MB589"));
        mbaCourses.add(new Course(2L, "HANA", "MB590"));
        mbaCourses.add(new Course(3L, "Modern management", "MB544"));
        mbaCourses.add(new Course(4L, "ERP", "MB472"));
        return mbaCourses;
    }
} // End of course repository class
