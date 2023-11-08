package edu.miu.ea.rest.controller;


import edu.miu.ea.rest.model.dto.RSCourseDTO;
import edu.miu.ea.rest.model.dto.RSStudentDTO;
import edu.miu.ea.rest.service.RSStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class RSStudentController {

    private final RSStudentService service;

    @PostMapping
    public RSStudentDTO addStudent(@RequestBody RSStudentDTO studentDTO) {
        return service.add(studentDTO);
    }

    @PutMapping("/{id}")
    public RSStudentDTO updateStudent(@PathVariable Integer id, @RequestBody RSStudentDTO studentDTO) throws Exception {
        return service.update(id, studentDTO);
    }

    @DeleteMapping("/{id}")
    public Boolean retireStudent(@PathVariable Integer id) throws Exception {
        return service.retire(id);
    }

    @GetMapping
    public List<RSStudentDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/search")
    public List<RSStudentDTO> findStudentByMajor(@RequestParam String major) {
        return service.getStudentsByMajor(major);
    }

    @GetMapping("/{id}")
    public RSStudentDTO findStudentByID(@PathVariable Integer id) throws Exception {
        return service.findById(id);
    }

    @GetMapping("/{id}/courses")
    public List<RSCourseDTO> findStudentCoursesByStudenId(@PathVariable Integer id) throws Exception {
        return service.getCoursesByStudentId(id);
    }

}
