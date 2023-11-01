package com.example.assignment1.services;

import com.example.assignment1.dto.FullStudentDto;
import com.example.assignment1.entities.Course;
import com.example.assignment1.entities.Student;
import com.example.assignment1.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepo studentRepo;

    private final ModelMapper modelMapper;

    @Override
    public List<FullStudentDto> getAllStudents() {

        List<FullStudentDto> result = new ArrayList<>();

        studentRepo.studentsList().forEach(student -> {
            var fullStudentDto = modelMapper.map(student, FullStudentDto.class);
            result.add(fullStudentDto);
        });

        return result;
    }

    //add Single students
    @Override
    public void saveStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void updateStudent(Long id, Student student) {
        studentRepo.update(id, student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.delete(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentByMajor(major);
    }

    @Override
    public List<Course> getAllCourseById(Long id) {
        return studentRepo.getCoursesByStudentId(id);
    }


}
