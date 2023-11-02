package miu.ea.nov.payload;

import lombok.*;
import miu.ea.nov.entity.Course;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentMinimalDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    //private List<Course> courseTaken;
}
