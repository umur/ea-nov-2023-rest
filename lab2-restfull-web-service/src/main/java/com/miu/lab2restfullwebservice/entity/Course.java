package com.miu.lab2restfullwebservice.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Course {
    private Integer id;
    private String name;
    private String code;
}
