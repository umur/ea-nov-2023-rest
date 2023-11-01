package com.miu.lab2restfullwebservice.repository;

import com.miu.lab2restfullwebservice.entity.Course;
import com.miu.lab2restfullwebservice.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private Set<Student> students = new HashSet<>();

    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    public void save(Student student) {
        this.students.add(student);
    }

    public Optional<Student> findById(Integer id) {
        return students.stream().filter(student -> student.getId().equals(id)).findAny();
    }

    public Optional<Student> findByEmail(String email) {
        return students.stream().filter(student -> student.getEmail().equals(email)).findAny();
    }

    public void deleteById(int id) {
        students = students.stream().filter(student -> !student.getId().equals(id)).collect(Collectors.toSet());
    }
}
