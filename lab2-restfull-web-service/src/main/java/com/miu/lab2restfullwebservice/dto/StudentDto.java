package com.miu.lab2restfullwebservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    @NotNull
    private Integer id;

    @NotNull
    @NotBlank
    @NotEmpty
    private String firstName;

    @NotNull
    @NotBlank
    @NotEmpty
    private String lastName;

    @NotNull
    @NotBlank
    @NotEmpty
    private String email;

    private CourseDto major;

    private double gpa;

    private List<CourseDto> coursesTaken;
}
