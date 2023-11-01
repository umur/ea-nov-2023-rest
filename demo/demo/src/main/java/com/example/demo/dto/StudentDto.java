package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StudentDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private double gpa;
    private String major;
    private List<CourseDto> coursesTaken;

}
