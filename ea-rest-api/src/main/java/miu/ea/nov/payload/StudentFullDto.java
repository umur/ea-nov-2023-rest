package miu.ea.nov.payload;

import lombok.*;
import miu.ea.nov.entity.Course;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentFullDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;
    private List<CourseDto> courseTaken;
}
