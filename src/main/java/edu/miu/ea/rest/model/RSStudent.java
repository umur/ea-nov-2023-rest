package edu.miu.ea.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RSStudent extends RSModel {

    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Double gpa;
    private List<RSCourse> coursesTaken;

    public RSStudent(Integer id, String firstName, String lastName, String email, String major, Double gpa, List<RSCourse> coursesTaken) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.gpa = gpa;
        this.coursesTaken = coursesTaken;
    }

}
