package com.example.lab2.Repository;


import com.example.lab2.DTO.SimpleStudentDto;
import com.example.lab2.Model.Course;
import com.example.lab2.Model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static List<Student> students = new ArrayList<>();
    private static List<SimpleStudentDto> SimpleStudents = new ArrayList<>();

    public void save(Student student) {
        students.add(student);
    }

    public List<Student> findAll() {
        return students;
    }
    public Optional<Student> findById(int id) {
        Optional<Student> student=students.stream().filter(c->c.getId()==id).findFirst();

        return student;


    }
    public void deleteById(int id){
        List<Student> newStudents=students.stream().filter(c->c.getId()!=id).collect(Collectors.toList());
        students=newStudents;
    }
    public List<SimpleStudentDto> findAllStudentsByMajor(String major){
        List<SimpleStudentDto> result=SimpleStudents.stream().filter(c->c.getMajor()==major)
                .collect(Collectors.toList());
        return result;
    }

}
