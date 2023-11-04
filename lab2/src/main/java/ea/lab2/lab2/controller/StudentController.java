package ea.lab2.lab2.controller;

import ea.lab2.lab2.dto.FullCourseDto;
import ea.lab2.lab2.dto.FullStudentDto;
import ea.lab2.lab2.entity.Student;
import ea.lab2.lab2.service.impl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentServiceImpl studentsServices;


    @GetMapping
    public List<FullStudentDto> findAll(){
        return studentsServices.findAll();
    }

    @GetMapping("/searchbymajor")
    public List<FullStudentDto> getStudentsByMajor(@RequestParam String major){
        return studentsServices.getStudentsByMajor(major);
    }

    @GetMapping("/{id}")
    public List<FullCourseDto> getCoursesByStudentId(@PathVariable int id){
        return studentsServices.getCoursesByStudentId(id);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentsServices.addStudent(student);
    }
}
