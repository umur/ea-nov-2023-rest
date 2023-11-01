package miu.ea.nov.controller;

import miu.ea.nov.payload.CourseDto;
import miu.ea.nov.service.impl.CourseServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Combination of @Controller and @ResponseBody annotations
@RequestMapping("/api/courses") // Base URL for REST API
public class CourseController {
    private final CourseServiceImpl courseService;

    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }


    /*
    Implement CRUD operations for the domains.
    Implement getStudentsByMajor(String major)
    Returns all courses of the student.*/

    @GetMapping("/find")
    public List<CourseDto> findAllCourses() {
        return courseService.findAll();
    }

    @PostMapping("/create")
    public void addCourse(CourseDto courseDto) {

    }

} // End of course controller
