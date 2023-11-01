package com.example.demo.repository;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class StudentRepo {
    private static List<Student> students = new ArrayList<>();
    private final ModelMapper modelMapper;

    public void save(Student student) {
        students.add(student);
    }

    public List<StudentDto> getAll() {
        return students.stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
    }

    public Optional<Student> findById(int studentId) {
        return students.stream().filter(student -> student.getId() == studentId).findFirst();
    }

    public List<CourseDto> getCoursesByStudentId(int studentId) {
        Optional<Student> studentOptional = findById(studentId);
        if (studentOptional.isPresent()) {
            List<Course> courses = studentOptional.get().getCoursesTaken();

            return courses.stream()
                    .map(course -> modelMapper.map(course, CourseDto.class))
                    .collect(Collectors.toList());
        } else {
            // Handle the case where the student with the given ID is not found.
            return new ArrayList<>();
        }
    }


    public void edit(int studentId, String firstName, String lastName, String email, double gpa, String major) {
        Optional<Student> studentOptional = findById(studentId);
        studentOptional.ifPresent(student -> {
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setEmail(email);
            student.setGpa(gpa);
            student.setMajor(major);
        });
    }

    public void deleteStudent(int studentId) {
        students.removeIf(student -> student.getId() == studentId);
    }

    public void addCourseToStudent(int studentId, Course course) {
        Optional<Student> studentOptional = findById(studentId);
        studentOptional.ifPresent(student -> {
            student.getCoursesTaken().add(course);
        });
    }
    public List<StudentDto> getStudentsByMajor(String major) {
        return students.stream()
                .filter(student -> student.getMajor().equals(major))
                .map(student -> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
    }

}
