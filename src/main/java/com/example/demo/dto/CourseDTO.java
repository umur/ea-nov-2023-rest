package com.example.demo.dto;

import com.example.demo.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CourseDTO {

    private int id;
    private String name;
    private String code;

}
