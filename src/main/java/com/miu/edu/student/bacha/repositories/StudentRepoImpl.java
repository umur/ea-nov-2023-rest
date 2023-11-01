package com.miu.edu.student.bacha.repositories;

import com.miu.edu.student.bacha.entities.Course;
import com.miu.edu.student.bacha.entities.Student;

import java.util.ArrayList;
import java.util.List;


public class StudentRepoImpl implements StudentRepo {
    static List<Student> students = new ArrayList<>();

    @Override
    public List<Student> findAll() {
        return students.stream().filter(s->!s.isDeleted()).toList();
    }

    @Override
    public Student findById(int id) {
        for (Student student: students) {
           if (student.getId()==id)
               return student;
        }
        throw new RuntimeException("No student with id " +id);
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public void deleteById(int id) {
        findById(id).setDeleted(true);
    }

    @Override
    public List<Student> findByMajor(String major) {
       return students
                .stream()
                .filter(student -> student.getMajor().equals(major)).toList();
    }

    @Override
    public List<Course> findCoursesByStudentId(int studentId) {
        return students
                .stream()
                .filter(s->s.getId()==studentId)
                .findFirst()
                .map(Student::getCoursesTaken)
                .orElseThrow(()-> new RuntimeException("Student with id "+studentId +" has not taken courses yet"));

    }
}
