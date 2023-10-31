package com.example.assignment1.repository;

import com.example.assignment1.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private static List<Student> students = new ArrayList<>();

    public List<Student>  findAll(){
        return students;
    }
}
