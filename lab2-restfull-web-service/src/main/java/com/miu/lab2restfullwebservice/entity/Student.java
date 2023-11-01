package com.miu.lab2restfullwebservice.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @EqualsAndHashCode.Include
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
    @EqualsAndHashCode.Include
    private String email;

    private Course major;

    private double gpa;

    private Set<Course> coursesTaken;

    private boolean deleted;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedBy;
}
