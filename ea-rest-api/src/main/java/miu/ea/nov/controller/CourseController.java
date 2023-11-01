package miu.ea.nov.controller;

import miu.ea.nov.service.CourseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Combination of @Controller and @ResponseBody annotations
@RequestMapping("/api/courses") // Base URL for REST API
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

} // End of course controller
