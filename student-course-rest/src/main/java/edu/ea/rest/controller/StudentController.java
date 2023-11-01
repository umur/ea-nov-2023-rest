package edu.ea.rest.controller;


import edu.ea.rest.dto.FullCourseDto;
import edu.ea.rest.dto.FullStudentDto;
import edu.ea.rest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<FullStudentDto> findAllStudents()
    {
      return   studentService.findAll();
    }

    @GetMapping("/search")
    public List<FullStudentDto> findStudentByMajor( @RequestParam String major)
    {
        return   studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}")
    public FullStudentDto findStudentByID(@PathVariable Integer id) throws Exception {
        return   studentService.findById(id);
    }

    @GetMapping("/{id}/courses")
    public List<FullCourseDto> findByStudentCourses(@PathVariable Integer id) throws Exception {
        return   studentService.getCoursesByStudentId(id);
    }

    @PostMapping
    public FullStudentDto addStudent(@RequestBody FullStudentDto fullStudentDto)  {
        return   studentService.addStudent(fullStudentDto);
    }



    @PutMapping("/{id}")
    public FullStudentDto updateStudent(@PathVariable Integer id,@RequestBody FullStudentDto fullStudentDto) throws Exception {
        return   studentService.update(id,fullStudentDto);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteStudent(@PathVariable Integer id) throws Exception {
        return   studentService.deleteStudent(id);
    }








}
