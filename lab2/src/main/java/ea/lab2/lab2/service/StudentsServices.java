package ea.lab2.lab2.service;

import ea.lab2.lab2.dto.FullCourseDto;
import ea.lab2.lab2.dto.FullStudentDto;
import ea.lab2.lab2.entity.Student;

import java.util.List;

public interface StudentsServices {
    List<FullStudentDto> getStudentsByMajor(String major);

    List<FullCourseDto> getCoursesByStudentId(int studentId);

    void addStudent(Student student);

    List<FullStudentDto> findAll();

}
