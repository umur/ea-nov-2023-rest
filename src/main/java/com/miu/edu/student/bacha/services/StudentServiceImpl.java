package com.miu.edu.student.bacha.services;

import com.miu.edu.student.bacha.entities.Course;
import com.miu.edu.student.bacha.entities.Student;
import com.miu.edu.student.bacha.repositories.StudentRepo;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepo.findById(id);
    }

    @Override
    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void updateStudent(int id, Student updatedStudent) {
        Student student = getStudentById(id);
        if(student !=null) {
            student.setFirstName(updatedStudent.getFirstName());
            student.setLastName(updatedStudent.getLastName());
            student.setEmail(updatedStudent.getEmail());
            student.setMajor(updatedStudent.getMajor());
            student.setGpa(updatedStudent.getGpa());
            student.setCoursesTaken(updatedStudent.getCoursesTaken());
        }
        else throw new RuntimeException("""
                Student with id ${id} does not exist.""");
    }

    @Override
    public void deleteStudent(int id) {
        studentRepo.deleteById(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.findByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepo.findCoursesByStudentId(studentId);
    }
}
