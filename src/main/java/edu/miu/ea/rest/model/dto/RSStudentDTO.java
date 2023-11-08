package edu.miu.ea.rest.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RSStudentDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Double gpa;
    private Boolean deleted;
    private List<RSCourseDTO> coursesTaken;
}
