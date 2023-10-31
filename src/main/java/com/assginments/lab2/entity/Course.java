package com.assginments.lab2.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {
    private int id;
    private String name;
    private String code;

    private boolean deleted = false;

}
