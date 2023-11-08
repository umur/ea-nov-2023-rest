package edu.miu.ea.rest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RSCourse extends RSModel {

    private String name;
    private String code;

    public RSCourse(Integer id, String name, String code) {
        super(id);
        this.name = name;
        this.code = code;
    }

}
