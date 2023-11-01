package com.example.lab1.myapp.service;

import com.example.lab1.myapp.dto.CourseDto;
import com.example.lab1.myapp.dto.StudentDto;
import com.example.lab1.myapp.model.Student;
import com.example.lab1.myapp.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepo StudentRepo;
    private final ModelMapper modelMapper;

    @Override
    public void save(Student student) {
        StudentRepo.save(student);
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> students = StudentRepo.findAll();
        var result = new ArrayList<StudentDto>();
        students.forEach(student -> {
            var dto = modelMapper.map(student, StudentDto.class);
            result.add(dto);
        } );
        return result;
    }

    @Override
    public StudentDto getById(Integer id) {
        var student = StudentRepo.findById(id);
        var dto = modelMapper.map(student, StudentDto.class);
        return dto;
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        var student = StudentRepo.getStudentsByMajor(major);
        var result = new ArrayList<StudentDto>();
        student.forEach(student1 -> {
            var dto = modelMapper.map(student1, StudentDto.class);
            result.add(dto);
        });
        return result;
    }

    @Override
    public List<CourseDto> getCourseByStudentId(int id) {
        var courses = StudentRepo.getCoursesByStudentId(id);
        var result = new ArrayList<CourseDto>();
        courses.forEach(course -> {
            var dto = modelMapper.map(course, CourseDto.class);
            result.add(dto);
        } );
        return result;
    }

    @Override
    public void delete(Integer id) {
        StudentRepo.delete(id);
    }

    @Override
    public void update(Integer id, StudentDto student) {
        var dto = modelMapper.map(student, Student.class);
        StudentRepo.update(id, dto);
    }
}