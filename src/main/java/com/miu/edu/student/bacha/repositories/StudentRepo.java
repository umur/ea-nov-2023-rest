package com.miu.edu.student.bacha.repositories;

import com.miu.edu.student.bacha.entities.Course;
import com.miu.edu.student.bacha.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo {
    List<Student> findAll();
    Student findById(int id);
    void save(Student student);
    void deleteById(int id);
    List<Student> findByMajor(String major);
    List<Course> findCoursesByStudentId(int studentId);
}
