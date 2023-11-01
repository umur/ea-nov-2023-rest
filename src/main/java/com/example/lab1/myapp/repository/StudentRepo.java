package com.example.lab1.myapp.repository;

import com.example.lab1.myapp.model.Course;
import com.example.lab1.myapp.model.Student;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepo {
    private static List<Student> students = new ArrayList<>();

    public StudentRepo() {
        Student student1 = new Student(1, "John", "Doe", "jdoe", "Computer Science", 3.5);
        Student student2 = new Student(2, "Jane", "Doe", "jdoe", "Computer Science", 3.5);
        Student student3 = new Student(3, "Joe", "Doe", "jdoe", "Computer Science", 3.5);
        students.add(student1);
        students.add(student2);
        students.add(student3);
    }

    public static void save(Student student) {
        students.add(student);
    }

    public static List<Student> findAll() {
        return students;
    }

    public static Student findById(Integer id) {
        for (Student student : students) {
            if (student.getId().equals(Integer.valueOf(id))) {
                return student;
            }
        }
        return null;
    }

    public static List<Student> getStudentsByMajor(String major) {
        List<Student> studentsByMajor = new ArrayList<>();
        for (Student student : students) {
            if (student.getMajor().equals(major)) {
                studentsByMajor.add(student);
            }
        }
        return studentsByMajor;
    }

    public static void delete(Integer id) {
        Student student = findById(id);
        if (student != null) {
            students.remove(student);
        }
    }

    public static List<Course> getCoursesByStudentId(int studentId) {
        List<Course> courses = new ArrayList<>();
        for (Student student : students) {
            if (student.getId() == studentId) {
                courses.addAll(student.getCourses());
            }
        }
        return courses;
    }

    public static void update(Integer id, Student student) {
        Student existingStudent = findById(id);
        if (existingStudent != null) {
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setMajor(student.getMajor());
            existingStudent.setGpa(student.getGpa());
        }
    }
}
