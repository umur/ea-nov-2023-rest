package com.assginments.lab2.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.assginments.lab2.dto.CourseDto;
import com.assginments.lab2.dto.NewStudentDto;
import com.assginments.lab2.dto.StudentDto;
import com.assginments.lab2.entity.Student;
import com.assginments.lab2.repository.CourseRepo;
import com.assginments.lab2.repository.StudentRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;
    private final ModelMapper mapper;

    public List<StudentDto> getAllStudents() {
        var students = studentRepo.getAllStudents();
        List<StudentDto> result = new ArrayList<>();

        students.forEach(stu -> {
            StudentDto stuDto = mapper.map(stu, StudentDto.class);
            result.add(stuDto);
        });

        return result;
    }

    public List<StudentDto> getStudentsByMajor(String major) {
        var students = studentRepo.getAllStudentsByMajor(major);
        List<StudentDto> result = new ArrayList<>();

        students.forEach(stu -> {
            StudentDto stuDto = mapper.map(stu, StudentDto.class);
            result.add(stuDto);
        });

        return result;
    }

    public List<CourseDto> getAllStudentCourses(int studentId) {
        var courses = studentRepo.getAllStudentCourses(studentId);
        List<CourseDto> result = new ArrayList<>();

        courses.forEach(course -> {
            CourseDto courseDto = mapper.map(course, CourseDto.class);
            result.add(courseDto);
        });

        return result;

    }

    public StudentDto getStudent(int id) {
        var student = studentRepo.getStudent(id);

        return mapper.map(student, StudentDto.class);
    }

    public void addStudent(NewStudentDto newStudent) {
        var student = mapper.map(newStudent, Student.class);
        studentRepo.addStudent(student);
    }

    public void removeStudent(int id) {
        if (studentRepo.doesExist(id))
            studentRepo.removeStudent(id);
    }

    public void updateStudent(int id, NewStudentDto updatedStudent) {
        if (studentRepo.doesExist(id)) {
            var student = mapper.map(updatedStudent, Student.class);
            student.setId(id);
            studentRepo.updateStudent(student);
        }
    }

    // public void addCourseToStudent(int id, NewCourseDto newCourse) {
    // var addedCourse = courseService.addCourse(newCourse);
    // var course = mapper.map(addedCourse, Course.class);
    // studentRepo.addCourseToStudent(id, course);
    // }

    public void addCourseToStudent(int id, int courseId) {
        var course = courseRepo.getCourse(courseId);
        var student = studentRepo.getStudent(id);

        if (student != null && course != null) {
            studentRepo.addCourseToStudent(student, course);
        }
    }

    public boolean doesExist(int id) {
        return studentRepo.doesExist(id);
    }
}
