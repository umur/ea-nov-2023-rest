package edu.ea.rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
  private  Integer  id;
  private String name;
  private String code;
  private Boolean deleted;

}
