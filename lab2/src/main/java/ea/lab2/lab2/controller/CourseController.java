package ea.lab2.lab2.controller;

import ea.lab2.lab2.dto.FullCourseDto;
import ea.lab2.lab2.entity.Course;
import ea.lab2.lab2.service.CourseServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseServices courseServices;


    @PostMapping
    public void addCourse(@RequestBody Course course){
        courseServices.addCourse(course);
    }

    @GetMapping
    public List<FullCourseDto> findAll(){
        return courseServices.findAll();
    }
}
