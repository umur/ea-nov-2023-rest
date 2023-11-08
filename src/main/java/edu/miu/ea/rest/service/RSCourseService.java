package edu.miu.ea.rest.service;

import edu.miu.ea.rest.model.dto.RSCourseDTO;

import java.util.List;

public interface RSCourseService {

    RSCourseDTO add(RSCourseDTO courseDTO);

    RSCourseDTO update(Integer id, RSCourseDTO courseDTO) throws Exception;

    List<RSCourseDTO> findAll();

    RSCourseDTO findById(Integer id) throws Exception;

    Boolean retire(Integer id) throws Exception;

}
