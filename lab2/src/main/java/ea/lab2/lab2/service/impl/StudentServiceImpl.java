package ea.lab2.lab2.service.impl;

import ea.lab2.lab2.dto.FullCourseDto;
import ea.lab2.lab2.dto.FullStudentDto;
import ea.lab2.lab2.entity.Course;
import ea.lab2.lab2.entity.Student;
import ea.lab2.lab2.repository.StudentRepository;
import ea.lab2.lab2.service.StudentsServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentsServices {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<FullStudentDto> getStudentsByMajor(String major) {
        List<Student> studentList = studentRepository.findAll();
        List<FullStudentDto> results = new ArrayList<>();
        List<Student> filteredStudents = studentList.stream()
                .filter(student -> student.getMajor().equals(major))
                .collect(Collectors.toList());

        filteredStudents.forEach(student -> {
            FullStudentDto fullStudentDto = modelMapper.map(student, FullStudentDto.class);
            results.add(fullStudentDto);
        });
        return results;
    }

    @Override
    public List<FullCourseDto> getCoursesByStudentId(int studentId) {
        List<Student> studentList = studentRepository.findAll();
        List<FullCourseDto> results = new ArrayList<>();
        List<Course> coursesTaken = new ArrayList<>();

        studentList.forEach(student -> {
            if(student.getId() == studentId){
                coursesTaken.addAll(student.getCoursesTaken());
            }
        });

        coursesTaken.forEach(course -> {
            FullCourseDto fullCourseDto= modelMapper.map(course,FullCourseDto.class);
            results.add(fullCourseDto);
        });

        return results;
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    @Override
    public List<FullStudentDto> findAll() {
        List<Student> studentList = studentRepository.findAll();
        List<FullStudentDto> results = new ArrayList<>();

        studentList.forEach(student -> {
            FullStudentDto fullStudentDto = modelMapper.map(student, FullStudentDto.class);
            results.add(fullStudentDto);
        });

        return results;
    }
}
