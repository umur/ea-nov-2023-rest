package miu.ea.nov.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;
    private List<Course> courseTaken;
}
