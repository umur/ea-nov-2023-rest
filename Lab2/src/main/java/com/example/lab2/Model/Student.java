package com.example.lab2.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Student {
    private int id;
    private String firstName;
    private String lastName;

    private String email;
    private String major;
    private float gpa;
    private List<Course> coursesTaken;
}
