package com.example.lab1.myapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;
}
