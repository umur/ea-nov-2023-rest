package com.example.demo.service.Impl;

import com.example.demo.dto.CourseDTO;
import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> studentList = studentRepo.findAll();

        List<StudentDTO> studentDTOList = new ArrayList<>();

        studentList.forEach(student -> {
            studentDTOList.add(modelMapper.map(student, StudentDTO.class));
        });

        return studentDTOList;
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()) {
            return modelMapper.map(student.get(), StudentDTO.class);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id " + id);
        }
    }

    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);
        student.setCreatedAt(LocalDateTime.now());
        Student savedStudent = studentRepo.save(student);
        return modelMapper.map(savedStudent, StudentDTO.class);
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Optional<Student> student = studentRepo.findById(id);

        if (student.isPresent()) {
            Student toBeUpdatedStudent = modelMapper.map(studentDTO, Student.class);
            toBeUpdatedStudent.setUpdatedAt(LocalDateTime.now());
            toBeUpdatedStudent.setId(id);
            Student updatedStudent = studentRepo.update(toBeUpdatedStudent);
            return modelMapper.map(updatedStudent, StudentDTO.class);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id " + id);
        }
    }

    @Override
    public void deleteStudent(Long id) {
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()) {
            Student deletedStudent = student.get();
            deletedStudent.setDeleted(true);
            deletedStudent.setDeletedAt(LocalDateTime.now());
            studentRepo.update(deletedStudent);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id " + id);
        }
    }


    @Override
    public List<StudentDTO> getStudentsByMajor(String major) {
        List<Student> studentList = studentRepo.findStudentsByMajor(major);
        List<StudentDTO> studentDTOList = new ArrayList<>();
        studentList.forEach(student -> {
            studentDTOList.add(modelMapper.map(student, StudentDTO.class));
        });

        return studentDTOList;
    }


    @Override
    public List<CourseDTO> getCoursesByStudentId(Long id) {
        Optional<Student> student = studentRepo.findById(id);

        if (student.isPresent()) {
            List<Course> courseList = student.get().getCoursesTaken();
            List<CourseDTO> courseDTOList = new ArrayList<>();
            courseList.forEach(course -> {
                courseDTOList.add(modelMapper.map(course, CourseDTO.class));
            });
            return courseDTOList;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id " + id);
        }
    }

}

