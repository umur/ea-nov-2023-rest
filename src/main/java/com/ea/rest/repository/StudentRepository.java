package com.ea.rest.repository;

import com.ea.rest.model.Course;
import com.ea.rest.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    static List<Student> students = new ArrayList<>();

    public void create(Student student) {
        students.add(student);
    }

    public List<Student> findAll() {
        return students;
    }

    public void update(Student student) {
        students = students.stream()
                .map(s -> s.getId().equals(student.getId()) ? student : s)
                .collect(Collectors.toList());
    }

    public Student getStudent(Long id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseGet(Student::new);
    }

    public void delete(Long id) {
        students.removeIf(s -> s.getId().equals(id));
    }

    public List<Course> getCoursesByStudentId(Long id) {
        return getStudent(id).getTakenCourses();
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter(s -> s.getMajor().equals(major))
                .collect(Collectors.toList());
    }
}
