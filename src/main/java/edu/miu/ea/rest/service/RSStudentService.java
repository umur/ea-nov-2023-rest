package edu.miu.ea.rest.service;

import edu.miu.ea.rest.model.dto.RSCourseDTO;
import edu.miu.ea.rest.model.dto.RSStudentDTO;

import java.util.List;

public interface RSStudentService {

    RSStudentDTO add(RSStudentDTO student);

    RSStudentDTO update(Integer id, RSStudentDTO student) throws Exception;

    List<RSStudentDTO> findAll();

    RSStudentDTO findById(Integer id) throws Exception;

    List<RSStudentDTO> getStudentsByMajor(String major);

    List<RSCourseDTO> getCoursesByStudentId(int id) throws Exception;

    Boolean retire(Integer id) throws Exception;

}
