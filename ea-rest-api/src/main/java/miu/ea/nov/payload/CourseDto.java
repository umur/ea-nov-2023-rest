package miu.ea.nov.payload;

import lombok.*;
import miu.ea.nov.entity.Course;
import miu.ea.nov.entity.Student;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private Long id;
    private String name;
    private String code;
    private Student student;
}
