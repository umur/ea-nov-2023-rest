package com.example.lab2.Service.Impl;

import com.example.lab2.DTO.SimpleStudentDto;
import com.example.lab2.Model.Course;
import com.example.lab2.Model.Student;
import com.example.lab2.Repository.StudentRepo;
import com.example.lab2.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    @Override
    public List<SimpleStudentDto> getStudentsByMajor(String major) {

        return studentRepo.findAllStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {

        List<Course> result=studentRepo.findById(studentId).get().getCoursesTaken();



        return result;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public void saveStudent(Student student) {
     studentRepo.save(student);
    }

    @Override
    public Student updateStudent(int id, Student student) throws Exception {
        Optional<Student> student1 = studentRepo.findById(id);
        if (student1.isPresent()) {
            Student newStudent=student1.get();
            newStudent.setFirstName(student.getFirstName());
            newStudent.setLastName(student.getLastName());
            newStudent.setEmail(student.getEmail());
            newStudent.setGpa(student.getGpa());
            newStudent.setCoursesTaken(student.getCoursesTaken());
            return newStudent;
        }else {throw new Exception("The course Not Found");}

    }

    @Override
    public void deleteStudent(int id) {
studentRepo.deleteById(id);
    }
}
