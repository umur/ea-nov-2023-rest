package edu.miu.ea.rest.controller;

import edu.miu.ea.rest.model.dto.RSCourseDTO;
import edu.miu.ea.rest.service.RSCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class RSCoursesController {

    private final RSCourseService service;

    @PostMapping
    RSCourseDTO addCourse(@RequestBody RSCourseDTO courseDTO) {
        return service.add(courseDTO);
    }

    @PutMapping("/{id}")
    RSCourseDTO updateCourse(@PathVariable Integer id, @RequestBody RSCourseDTO courseDTO) throws Exception {
        return service.update(id, courseDTO);
    }

  @DeleteMapping("/{id}")
  Boolean retireCourse(@PathVariable Integer id) throws Exception {
    return service.retire(id);
  }

  @GetMapping
    List<RSCourseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    RSCourseDTO findByCourseId(@PathVariable Integer id) throws Exception {
        return service.findById(id);
    }

}
