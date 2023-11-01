package com.example.demo.service.impl;

import com.example.demo.dto.Coursedto;
import com.example.demo.dto.Studentdto;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentServiceimp implements StudentService {

    private final StudentRepo studentrepo;
    private final ModelMapper modelMapper;
    @Override
    public void save(Studentdto student) {
        studentrepo.save(modelMapper.map(student, Student.class));
    }

    @Override
    public List<Studentdto> findAll() {
        List<Student> students = studentrepo.findAll();
        return students.stream()
                .map(student -> modelMapper.map(student, Studentdto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Studentdto findByStudentId(int id) {
        Student student = studentrepo.findByID(id);
        return modelMapper.map(student, Studentdto.class);
    }

    @Override
    public void update(Studentdto student) {
        studentrepo.update(modelMapper.map(student,Student.class));
    }

    @Override
    public void delete(int id) {
        studentrepo.delete(id);

    }

    @Override
    public List<Studentdto> getStudentsByMajor(String major) {
        List<Student> students = studentrepo.findAll();
        return students.stream().filter(student -> student.getMajor().equals(major))
                .map(student -> modelMapper.map(student, Studentdto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Coursedto> getCoursesByStudentId(int id) {
        Student student = studentrepo.findByID(id);
        List<Coursedto> courses = student.getCoursesTaken().stream()
                .map(course -> modelMapper.map(course, Coursedto.class))
                .collect(Collectors.toList());
        return courses;
    }
}
