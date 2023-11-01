package miu.ea.nov.payload;

import lombok.Data;
import miu.ea.nov.entity.Course;

import java.util.List;

@Data
public class StudentMinimalDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String major;
    private List<Course> courseTaken;
}
