package com.example.lab1.myapp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;
    private List<Course> coursesTaken = new ArrayList<>();

    public Student() {

    }

    public Student(String firstName, String lastName, String email, String major, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.gpa = gpa;
    }

    public Student(Integer i, String john, String doe, String s, String computerScience, double v) {
        this.id = i;
        this.firstName = john;
        this.lastName = doe;
        this.email = s;
        this.major = computerScience;
        this.gpa = v;
    }

    public List<Course> getCourses() {
        return coursesTaken;
    }
}
