package com.example.RestFulllab.service.implementation;

import com.example.RestFulllab.entity.Course;
import com.example.RestFulllab.entity.Student;
import com.example.RestFulllab.repository.StudentRepo;
import com.example.RestFulllab.service.CourseService;
import com.example.RestFulllab.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final CourseService courseService;
    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public List<Student> getall() {
        return studentRepo.getall();
    }

    @Override
    public Student getStudentById(int id) {

        Optional<Student> s1=studentRepo.getStudentById(id);
        if(s1.isPresent())
        {
            return s1.get();
        }
        throw new RuntimeException("No Student Found For This ID");
    }

    @Override
    public void addCourse(int studentId, int courseId) {
        System.out.println("student service: Studentid: "+studentId +" courseID: "+courseId);
        Student stu= getStudentById(studentId);
        Course course = courseService.getCourseById(courseId);
        studentRepo.addCourse(stu,course);
    }

    @Override
    public Student updateStudent(int studentId, Student newStudent) {
        Optional<Student> s1=studentRepo.getStudentById(studentId);
        if(s1.isPresent())
        {
            return studentRepo.updateStudent(studentId,newStudent);
        }
        throw new RuntimeException("No Student With This Id");
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return studentRepo.getCoursesByStudentId(id);
    }


}
