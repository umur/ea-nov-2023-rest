package miu.ea.nov.service.impl;


import miu.ea.nov.entity.Student;
import miu.ea.nov.payload.StudentFullDto;
import miu.ea.nov.payload.StudentMinimalDto;
import miu.ea.nov.repository.StudentRepository;
import miu.ea.nov.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentFullDto createStudent(StudentFullDto studentDto) {
        return null;
    }


    @Override
    public List<StudentMinimalDto> findAllStudents() {

        List<Student> students = studentRepository.findAllStudent();
        return students.stream().map(s -> mapToDto(s)).collect(Collectors.toList());
    }

    //Converting Entity into DTO
    private StudentMinimalDto mapToDto(Student student){
        StudentMinimalDto studentMinimalDto = new StudentMinimalDto();
        studentMinimalDto.setId(student.getId());
        studentMinimalDto.setFirstName(student.getFirstName());
        studentMinimalDto.setLastName(student.getLastName());
        studentMinimalDto.setEmail(student.getEmail());
        studentMinimalDto.setMajor(student.getMajor());
        return studentMinimalDto;
    }

    // Convert DTO to Entity
    private Student mapToEntity(StudentMinimalDto studentMinimalDto){
        Student student = new Student();
        student.setId(studentMinimalDto.getId());
        student.setFirstName(studentMinimalDto.getFirstName());
        student.setLastName(studentMinimalDto.getLastName());
        student.setEmail(studentMinimalDto.getEmail());
        student.setMajor(studentMinimalDto.getMajor());
        return student;
    }
} // End of Student Service Implementation class.
