package com.assignment.assignment1.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {

    private int id;
    private String name;
    private String code;

    private boolean isDeleted;
}
