package com.miu.edu.student.bacha.services;

import com.miu.edu.student.bacha.entities.Course;
import com.miu.edu.student.bacha.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(int id);

    void addStudent(Student student);

    void updateStudent(int id, Student updatedStudent);

    void deleteStudent(int id);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(int studentId);
}



