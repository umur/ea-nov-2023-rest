package ea.lab2.lab2.service;

import ea.lab2.lab2.dto.FullCourseDto;
import ea.lab2.lab2.entity.Course;

import java.util.List;

public interface CourseServices {

    void addCourse(Course course);

    List<FullCourseDto> findAll();
}
