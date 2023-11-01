package com.example.assignment1.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
//@AllArgsConstructor
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;
    private List<Course> coursesTaken=new ArrayList<>();

}
