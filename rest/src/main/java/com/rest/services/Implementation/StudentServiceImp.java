package com.rest.services.Implementation;

import com.rest.domains.entities.Course;
import com.rest.domains.entities.Student;
import com.rest.repositories.StudentRepo;
import com.rest.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {

    StudentRepo studentRepo;

    @Autowired
    public StudentServiceImp(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    };
    @Override
    public void save(Student s) {
        studentRepo.save(s);
    };

    @Override
    public Student getById(int id) {
        return studentRepo.getById(id);
    };

    @Override
    public List<Student> getAll() {
        return studentRepo.getAll();
    };

    @Override
    public void update(int id, Student student) {
        studentRepo.update(id, student);
    };

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    };

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    };

};

