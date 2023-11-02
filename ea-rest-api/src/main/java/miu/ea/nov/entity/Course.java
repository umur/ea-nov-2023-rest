package miu.ea.nov.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Long id;
    private String name;
    private String code;
    private Student student;
}
