package edu.ea.rest.service;




import edu.ea.rest.dto.FullCourseDto;
import edu.ea.rest.dto.FullStudentDto;

import java.util.List;

public interface StudentService {
    List<FullStudentDto> findAll();
    FullStudentDto findById(Integer id ) throws Exception;
    FullStudentDto addStudent(FullStudentDto student)  ;
    FullStudentDto update(Integer id, FullStudentDto student ) throws Exception;
    Boolean deleteStudent(Integer id) throws Exception;
   List<FullStudentDto> getStudentsByMajor(String major);

   List<FullCourseDto> getCoursesByStudentId(int studentId) throws Exception;

}
