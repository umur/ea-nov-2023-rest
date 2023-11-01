package edu.ea.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FullStudentDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Double gpa;
    private Boolean deleted;
    private List<FullCourseDto> coursesTaken;
}
