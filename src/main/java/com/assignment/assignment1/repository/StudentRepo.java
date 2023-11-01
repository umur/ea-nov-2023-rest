package com.assignment.assignment1.repository;

import com.assignment.assignment1.domain.Course;
import com.assignment.assignment1.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class StudentRepo {

    private final CourseRepo courseRepo;

    private static List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1, "n1", "l1", "e1", "compro", 3.10,  Arrays.asList(1,4), false),
            new Student(2, "n2", "l2", "e2", "compro", 3.20,  Arrays.asList(1,2), false),
            new Student(3, "n3", "l3", "e3", "msd", 3.40,  Arrays.asList(1,2,3,4), false),
            new Student(4, "n4", "l4", "e4", "compro", 3.20,  Arrays.asList(2,3,4), false)
    ));

    public Student save(Student student) {
        students.add(student);
        return student;
    }

    public List<Student> findAll() {
        return students.stream()
                .filter(s -> !s.isDeleted())
                .toList();
    }

    public Optional<Student> findById(int id){
        return students.stream()
                .filter(s -> s.getId() == id)
                .filter(s -> !s.isDeleted() )
                .findFirst();
    }

    public List<Student> getStudentsByMajor(String major){
        return students.stream()
                .filter(s -> s.getMajor().equals(major))
                .toList();
    }

    public List<Course> getCoursesByStudentId(int studentId){
        return students.stream()
                .filter(s -> s.getId() == studentId)
                .flatMap(s -> s.getCoursesTakenIds().stream())
                .map(id -> courseRepo.findById(id).orElse(null))
                .filter(Objects::nonNull)
                .toList();
    }

    public Optional<Student> delete(int id) {
        Optional<Student> studentOptional = findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setDeleted(true);
        }
        return studentOptional;
    }

    public Optional<Student> put(int id, Student updatedStudent) {
        Optional<Student> studentOptional = findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setId(updatedStudent.getId());
            student.setEmail(updatedStudent.getEmail());
            student.setGpa(updatedStudent.getGpa());
            student.setMajor(updatedStudent.getMajor());
            student.setFirstName(updatedStudent.getFirstName());
            student.setCoursesTakenIds(updatedStudent.getCoursesTakenIds());
            student.setLastName(updatedStudent.getLastName());
        }
        return studentOptional;
    }
}
