package com.assginments.lab2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewStudentDto {
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;
}
