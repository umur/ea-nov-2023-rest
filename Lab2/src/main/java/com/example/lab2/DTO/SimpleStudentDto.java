package com.example.lab2.DTO;

import com.example.lab2.Model.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SimpleStudentDto {
    private int id;
    private String firstName;
    private String lastName;

    private String major;
}
