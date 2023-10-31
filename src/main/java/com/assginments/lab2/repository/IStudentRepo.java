package com.assginments.lab2.repository;

import java.util.List;

import com.assginments.lab2.entity.Course;
import com.assginments.lab2.entity.Student;

public interface IStudentRepo {

    void addStudent(Student student);

    void removeStudent(int StudentId);

    void updateStudent(Student updatedStudent);

    List<Student> getAllStudents();

    List<Student> getAllStudentsByMajor(String major);

    List<Course> getAllStudentCourses(int studentId);

    Student getStudent(int id);

    void addCourseToStudent(Student student, Course course);

    boolean doesExist(int studentId);

}