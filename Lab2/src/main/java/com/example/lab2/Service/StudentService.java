package com.example.lab2.Service;

import com.example.lab2.DTO.SimpleStudentDto;
import com.example.lab2.Model.Course;
import com.example.lab2.Model.Student;

import java.util.List;

public interface StudentService {
  List<SimpleStudentDto> getStudentsByMajor(String major);
  List<Course> getCoursesByStudentId(int studentId);
  List<Student> findAllStudents();
  void saveStudent(Student student);
  Student updateStudent(int id,Student student) throws Exception;
  void deleteStudent(int id);
}
