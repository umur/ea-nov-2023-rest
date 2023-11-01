package com.assignment.assignment1.dto;

import com.assignment.assignment1.domain.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostStudentDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;
    private List<Integer> coursesTakenIds;

}
