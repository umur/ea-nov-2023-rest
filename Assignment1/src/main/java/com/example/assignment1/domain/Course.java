package com.example.assignment1.domain;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
//@RequiredArgsConstructor
public class Course {
    private int id;
    private String name;
    private String code;
}
