package com.miu.lab2restfullwebservice.service.impl;

import com.miu.lab2restfullwebservice.dto.CourseDto;
import com.miu.lab2restfullwebservice.dto.StudentDto;
import com.miu.lab2restfullwebservice.entity.Course;
import com.miu.lab2restfullwebservice.entity.Student;
import com.miu.lab2restfullwebservice.repository.StudentRepository;
import com.miu.lab2restfullwebservice.service.StudentService;
import lombok.RequiredArgsConstructor;
import com.miu.lab2restfullwebservice.common.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final Converter converter;
    private final StudentRepository repository;
    private int sequenceId = 1;

    @Override
    public List<StudentDto> findAll() {
        return converter.convertList(repository.findAll(), StudentDto.class);
    }

    public StudentDto save(StudentDto studentDto) {
        return Optional.ofNullable(studentDto.getId())
                .map(s->update(studentDto))
                .orElseGet(()->{
                    create(studentDto);
                    return studentDto;
                });
    }

    private void create(StudentDto studentDto) {
        studentDto.setId(sequenceId++);
        repository.save(converter.convert(studentDto, Student.class));
    }

    private StudentDto update(StudentDto student) {
        repository.save(converter.convert(student, Student.class));
        return student;
    }

    @Override
    public Optional<StudentDto> findById(Integer id) {
        return Optional.ofNullable(repository.findById(id).map(s -> converter.convert(s, StudentDto.class)).orElse(null));
    }

    @Override
    public Optional<StudentDto> findByEmail(String email) {
        return Optional.ofNullable(repository.findByEmail(email).map(s -> converter.convert(s, StudentDto.class)).orElse(null));
    }

    @Override
    public void delete(int studentId) {
        repository.findById(studentId).map(s-> {
            repository.deleteById(s.getId());
            return s;
        }).orElseThrow(() -> new RuntimeException("No student found"));
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        List<Student> students = repository.findAll().stream().filter(student -> student.getMajor().getCode().equals(major)).collect(Collectors.toList());
        return converter.convertList(students, StudentDto.class);
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        return (List<CourseDto>) repository.findById(studentId)
                .map(s -> converter.convert(s.getCoursesTaken(), CourseDto.class))
                .orElseThrow(() -> new RuntimeException("No courses taken"));
    }
}
