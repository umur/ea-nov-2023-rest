package com.assignment.assignment1.service;

import com.assignment.assignment1.entity.Course;
import com.assignment.assignment1.entity.Student;
import com.assignment.assignment1.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;
    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void  delete(int id) {
        Optional<Student>result=findAll().stream()
                .filter(s->s.getId()==id)
                .findFirst();
        Student student=result.orElseThrow(()-> new NoSuchElementException("Student not found"));
        student.setDeleted(true);
    }

    @Override
    public void update(Student student) {
        Optional<Student>result=findAll().stream()
                .filter(s->s.getId()==student.getId())
                .findFirst();
        Student student1=result.orElseThrow(()-> new NoSuchElementException("Student not found"));
       student1.setDeleted(true);


    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getStudentByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return studentRepository.getCoursesByStudentId(id);
    }
}
