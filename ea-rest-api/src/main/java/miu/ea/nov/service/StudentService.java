package miu.ea.nov.service;

import miu.ea.nov.payload.StudentFullDto;
import miu.ea.nov.payload.StudentMinimalDto;

public interface StudentService {
    StudentFullDto createStudent(StudentFullDto studentDto);
    StudentMinimalDto getStudent(StudentMinimalDto studentMinimalDto);
}
