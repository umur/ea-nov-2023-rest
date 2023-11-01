package com.rest.domains.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Course {

    private int id;
    private String name;
    private String code;
}
