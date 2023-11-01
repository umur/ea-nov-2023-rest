package com.example.assignment1.dto;

import com.example.assignment1.entities.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FullStudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private String gpa;
    private List<Course> coursesTaken;
}
