package miu.ea.nov.controller;

import miu.ea.nov.payload.CourseDto;
import miu.ea.nov.service.impl.CourseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Combination of @Controller and @ResponseBody annotations
@RequestMapping("/api/") // Base URL for REST API
public class CourseController {
    private final CourseServiceImpl courseService;

    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }


    /*
    Implement CRUD operations for the domains.
    Implement getCoursesByStudentId(int )
    Returns all courses of the student.*/

    @PostMapping("/students/{studentId}/courses")
    public ResponseEntity<CourseDto> createCourse(@PathVariable(name = "studentId") long studentId,
                                                  @RequestBody CourseDto courseDto){
        return new ResponseEntity<>(courseService.createCourse(studentId, courseDto), HttpStatus.CREATED);
    }

    // Implement getCoursesByStudentId(int studentId)
    @GetMapping("/students/{studentId}/courses")
    public List<CourseDto> getCoursesByStudentId(@PathVariable(name="studentId") long studentId){
        return courseService.getCoursesByStudentId(studentId);
    }

} // End of course controller
