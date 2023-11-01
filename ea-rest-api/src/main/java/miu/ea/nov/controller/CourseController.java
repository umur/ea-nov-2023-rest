package miu.ea.nov.controller;

import miu.ea.nov.service.impl.CourseServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

} // End of course controller
