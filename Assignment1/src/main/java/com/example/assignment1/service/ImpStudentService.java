package com.example.assignment1.service;

import com.example.assignment1.domain.Student;
import com.example.assignment1.dto.StudentDto;
import com.example.assignment1.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ImpStudentService implements StudentService{
    private final StudentRepository studentRepo;
    private final ModelMapper modelMapper;

    @Override
        public List<StudentDto> findAll() {
            List<Student> productList = studentRepo.findAll();
            List<StudentDto> result = new ArrayList<StudentDto>();
            productList.forEach(student -> {
                var fullStudentDto = modelMapper.map(student, StudentDto.class);
                result.add(fullStudentDto);
            });
            return result;
        }


    @Override
    public void addStudent( StudentDto  studentDto){
        var student = modelMapper.map(studentDto, Student.class);
        studentRepo.save(student);
    }

    @Override
    public StudentDto updateStudent(int id, StudentDto studentDto){
        Student student = modelMapper.map(studentDto, Student.class);
        Student stu = studentRepo.update(id, student);
        StudentDto updateStudentDto = modelMapper.map(stu, StudentDto.class);
        return updateStudentDto;
    }

    @Override
    public void deleteStudent(int id){
        studentRepo.deleteStudent(id);
    }

    @Override
    public List<StudentDto> getStudentByMajor(String major){
        List<Student> stu = studentRepo.findAll();
        return stu.stream().
                filter(student -> student.getMajor().equals(major))
                .map(student -> modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getCoursesByStudentId(int id){
        List<Student> stu = studentRepo.findAll();
        return stu.stream().
                filter(student -> student.getId() == id)
                .map(student -> modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
    }

}
