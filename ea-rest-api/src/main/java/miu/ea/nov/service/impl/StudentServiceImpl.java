package miu.ea.nov.service.impl;


import miu.ea.nov.entity.Student;
import miu.ea.nov.payload.StudentFullDto;
import miu.ea.nov.payload.StudentMinimalDto;
import miu.ea.nov.repository.StudentRepository;
import miu.ea.nov.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentFullDto createStudent(StudentFullDto studentFullDto) {
        // Convert DTO to Entity
        Student student = new Student();
        student.setId(studentFullDto.getId());
        student.setFirstName(studentFullDto.getFirstName());
        student.setLastName(studentFullDto.getLastName());
        student.setEmail(studentFullDto.getEmail());
        student.setMajor(studentFullDto.getMajor());
        student.setGpa(studentFullDto.getGpa());
        return null;
    }

    public StudentMinimalDto getStudent(StudentMinimalDto studentMinimalDto) {
        return null;
    }
}
