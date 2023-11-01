package edu.ea.rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Double gpa;
    private Boolean deleted;
    private List<Course> coursesTaken;
}
