package com.example.lab2.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Course {

    private int id;
    private String name;
    private String code;
}
