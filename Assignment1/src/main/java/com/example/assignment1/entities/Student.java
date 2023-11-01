package com.example.assignment1.entities;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private String gpa;

    private List<Course> coursesTaken;
}
