package com.example.demo.service.impl;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Service
@RestController
public class StudentService implements com.example.demo.service.StudentService {
    private final StudentRepo studentRepo;

    @Override
    public List<StudentDto> finAll() {
        return studentRepo.getAll();
    }

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }


    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }

    @Override
    public void deleteStudent(int studentId) {
        studentRepo.deleteStudent(studentId);
    }

    @Override
    public void editStudent(int studentId, Student student) {
        studentRepo.edit(studentId, student.getFirstName(),student.getFirstName(), student.getEmail(), student.getGpa(), student.getMajor());
    }

    @Override
    public void addCourse(int studentId, Course course) {
        studentRepo.addCourseToStudent(studentId, course);
    }


}
