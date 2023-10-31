package com.assginments.lab2.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.assginments.lab2.entity.Course;
import com.assginments.lab2.entity.Student;

@Repository
public class StudentRepo implements IStudentRepo {
    private List<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        student.setId(students.size() + 1);
        students.add(student);
    }

    @Override
    public void removeStudent(int StudentId) {
        var student = getStudent(StudentId);
        student.setDeleted(true);
        // Students = Students.stream().filter(x -> x.getId() != StudentId).toList();
    }

    @Override
    public void updateStudent(Student updatedStudent) {
        var student = getStudent(updatedStudent.getId());

        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());
        student.setMajor(updatedStudent.getMajor());
        student.setGpa(updatedStudent.getGpa());
        // students = students.stream().filter(x -> x.getId() != id).toList();
        // students.add(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return students.stream().filter(s -> !s.isDeleted()).toList();
    }

    @Override
    public List<Student> getAllStudentsByMajor(String major) {
        return students.stream().filter(s -> s.getMajor().equals(major)).toList();
    }

    @Override
    public List<Course> getAllStudentCourses(int studentId) {
        return getStudent(studentId).getCoursesTaken();
    }

    @Override
    public Student getStudent(int id) {
        return students.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void addCourseToStudent(Student student, Course course) {
        student.getCoursesTaken().add(course);
    }

    @Override
    public boolean doesExist(int studentId) {
        return getStudent(studentId) != null;
    }

}
