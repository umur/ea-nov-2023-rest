package com.example.demo.service;

import com.example.demo.dto.Coursedto;
import com.example.demo.dto.Studentdto;
import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {

    void save (Studentdto student);
    List<Studentdto> findAll();
    Studentdto findByStudentId(int id);

    void update(Studentdto student);

    void delete(int id);

    List<Studentdto> getStudentsByMajor(String major);

    List<Coursedto> getCoursesByStudentId(int id);

}
