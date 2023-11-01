package com.assignment.assignment1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.*;

@Getter
@Setter
@Entity
public class Course {
    @Id
    private int id;
    private String name;
    private String code;

}
