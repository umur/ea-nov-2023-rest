package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Course {

    private Long id;
    private String name;
    private String code;

    private boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;



    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Course course) {
            return Objects.equals(course.getId(), this.getId());
        }
        return false;
    }
}
