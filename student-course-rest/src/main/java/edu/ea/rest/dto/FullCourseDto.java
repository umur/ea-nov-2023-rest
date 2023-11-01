package edu.ea.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FullCourseDto {
  private  Integer  id;
  private String name;
  private String code;
  private Boolean deleted;

}
