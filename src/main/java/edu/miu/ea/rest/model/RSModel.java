package edu.miu.ea.rest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RSModel {

    private Integer id;
    private Boolean retired;

    public RSModel(Integer id) {
        this.id = id;
    }

}
