package miu.ea.nov.service;

import miu.ea.nov.payload.StudentFullDto;
import miu.ea.nov.payload.StudentMinimalDto;

import java.util.List;

public interface StudentService {
    StudentFullDto createStudent(StudentFullDto studentDto);
    public List<StudentMinimalDto> findAllStudents();

    public StudentMinimalDto getStudentById(long id);
    public StudentMinimalDto getStudentsByMajor(String major);
}
