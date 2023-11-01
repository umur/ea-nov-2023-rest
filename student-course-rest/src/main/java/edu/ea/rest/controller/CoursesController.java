package edu.ea.rest.controller;

import edu.ea.rest.dto.FullCourseDto;
import edu.ea.rest.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CoursesController {
  private final CourseService courseService;

    @GetMapping
    List<FullCourseDto> findAllCourses()
    {
        return  courseService.findAll();

    }

  @GetMapping("/{id}")
   FullCourseDto  findByCourseId(@PathVariable  Integer id) throws Exception {
    return  courseService.findById(id);

  }


  @PostMapping
  FullCourseDto addCourse(@RequestBody FullCourseDto fullCourseDto)
  {
    return  courseService.addCourse(fullCourseDto);
  }
  @PutMapping ("/{id}")
  FullCourseDto  updateCourse(@PathVariable  Integer id,@RequestBody FullCourseDto fullCourseDto) throws Exception {
    return  courseService.update(id,fullCourseDto);

  }

  @DeleteMapping ("/{id}")
  Boolean  deleteCourse(@PathVariable  Integer id ) throws Exception {
    return  courseService.delete(id);

  }


}
