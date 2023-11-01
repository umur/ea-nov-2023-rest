package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {

    public List<StudentDto> finAll();

    public void save(Student student);

    public List<CourseDto> getCoursesByStudentId(int studentId);
    public List<StudentDto> getStudentsByMajor(String major);

    public void deleteStudent(int studentId);
    public void editStudent(int studentId, Student student);
    public void addCourse(int studentId, Course course);
}
