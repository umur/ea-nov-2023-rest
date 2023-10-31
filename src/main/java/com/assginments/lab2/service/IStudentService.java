package com.assginments.lab2.service;

import java.util.List;

import com.assginments.lab2.dto.CourseDto;
import com.assginments.lab2.dto.NewStudentDto;
import com.assginments.lab2.dto.StudentDto;

public interface IStudentService {

    List<StudentDto> getAllStudents();

    List<StudentDto> getStudentsByMajor(String major);

    List<CourseDto> getAllStudentCourses(int studentId);

    StudentDto getStudent(int id);

    void addStudent(NewStudentDto newStudent);

    void removeStudent(int id);

    void updateStudent(int id, NewStudentDto updatedStudent);

    void addCourseToStudent(int id, int courseId);

    boolean doesExist(int id);

}