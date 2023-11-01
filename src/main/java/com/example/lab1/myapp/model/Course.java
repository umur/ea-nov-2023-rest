package com.example.lab1.myapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {
    private int id;
    private String name;
    private String code;

    public Course() {
    }

    public Course(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Course(int i, String s, String cse101) {
        this.id = i;
        this.name = s;
        this.code = cse101;
    }
}
