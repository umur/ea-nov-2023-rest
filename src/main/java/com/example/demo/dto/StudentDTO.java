package com.example.demo.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class StudentDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;

    private List<CourseDTO> coursesTaken;

}
