package com.assignment.assignment1.service.impl;

import com.assignment.assignment1.domain.Course;
import com.assignment.assignment1.domain.Student;
import com.assignment.assignment1.dto.FullStudentDto;
import com.assignment.assignment1.dto.PostStudentDto;
import com.assignment.assignment1.repository.CourseRepo;
import com.assignment.assignment1.repository.StudentRepo;
import com.assignment.assignment1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    @Override
    public FullStudentDto save(PostStudentDto postStudentDto) {
        Student student = modelMapper.map(postStudentDto, Student.class);
        student.setDeleted(false);
        FullStudentDto fullStudentDto = modelMapper.map(studentRepo.save(student), FullStudentDto.class);
        List<Course> courseList = new ArrayList<>();
        student.getCoursesTakenIds().forEach(id -> {
            courseRepo.findById(id).ifPresent(courseList::add);
        });
        fullStudentDto.setCoursesTaken(courseList);
        return fullStudentDto;
    }

    @Override
    public List<FullStudentDto> findAll() {
        List<Student> studentList = studentRepo.findAll();
        return studentList.stream()
                .map(this::getFullStudentDtoFromStudent)
                .toList();
    }

    @Override
    public FullStudentDto findById(int id) {
        Optional<Student> optionalStudent = studentRepo.findById(id);
        return optionalStudent.map(this::getFullStudentDtoFromStudent).orElse(null);
    }

    @Override
    public List<FullStudentDto> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major).stream()
                .map(this::getFullStudentDtoFromStudent)
                .toList();
    }

    @Override
    public FullStudentDto delete(int id) {
        Optional<Student> optionalStudent = studentRepo.delete(id);
        return optionalStudent.map(this::getFullStudentDtoFromStudent).orElse(null);
    }

    @Override
    public FullStudentDto put(int id, PostStudentDto student) {
        Optional<Student> optionalStudent = studentRepo.put(id, modelMapper.map(student, Student.class));
        if (optionalStudent.isPresent()) {
            return optionalStudent.map(this::getFullStudentDtoFromStudent).orElse(null);
        }
        return null;
    }

    private FullStudentDto getFullStudentDtoFromStudent(Student student) {
        FullStudentDto fullStudentDto = modelMapper.map(student, FullStudentDto.class);
        List<Course> courses = new ArrayList<>();
        student.getCoursesTakenIds().forEach(courseId -> {
            Optional<Course> course = courseRepo.findById(courseId);
            course.ifPresent(courses::add);
        });
        fullStudentDto.setCoursesTaken(courses);
        return fullStudentDto;
    }
}
