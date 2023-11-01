package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {

    static List<Student> students = new ArrayList<>();

    StudentRepo() {
        Student student = new Student();
        student.setId(1L);
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("JohnDoe@miu.edu");
        student.setMajor("Computer Science");
        student.setGpa(3.5);
        student.setCoursesTaken(CourseRepo.courses);

        Student student2 = new Student();
        student2.setId(2L);
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setEmail("JaneDoe@miu.edu");
        student2.setMajor("Information Technology");
        student2.setGpa(3.5);
        student2.setCoursesTaken(CourseRepo.courses);

        students.addAll(List.of(student, student2));
    }


    public Student save(Student student) {
        students.add(student);
        return student;
    }

    public Student update(Student student) {
        for (Student s : students) {
            if (Objects.equals(s.getId(), student.getId())) {
                s = student;
            }
        }
        return student;
    }

    public Optional<Student> findById(Long id) {
        return findAll().stream().filter(student -> student.getId() == id).findFirst();
    }

    public List<Student> findAll() {
        return students.stream().filter(student -> !student.isDeleted()).collect(Collectors.toList());
    }

    public List<Student> findStudentsByMajor(String major) {
        return findAll().stream().filter(student -> student.getMajor().equals(major)).toList();
    }
}
