package miu.ea.nov.service;

import miu.ea.nov.payload.StudentFullDto;
import miu.ea.nov.payload.StudentMinimalDto;

import java.util.List;

public interface StudentService {
    StudentFullDto createStudent(StudentFullDto studentDto);
    public List<StudentMinimalDto> findAllStudents();

    public StudentMinimalDto getStudentById(long id);
    public List<StudentMinimalDto> getStudentsByMajor(String major);
    public StudentMinimalDto updateStudent(StudentMinimalDto studentMinimalDto, long id);

    void deleteStudentById(long id);
}
