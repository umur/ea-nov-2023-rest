package edu.miu.ea.rest.model.dto;

import lombok.Data;

@Data
public class RSCourseDTO {

    private Integer id;
    private String name;
    private String code;
    private Boolean retired;

}
