package miu.ea.nov.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Course {
    private Long id;
    private String name;
    private String code;
}
