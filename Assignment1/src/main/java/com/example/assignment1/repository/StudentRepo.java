package com.example.assignment1.repository;

import com.example.assignment1.entities.Course;
import com.example.assignment1.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private List<Student> studentsList;


    public StudentRepo(){
        studentsList = new ArrayList<>();

        Student s1 = new Student();
        s1.setId(1L);
        s1.setFirstName("John");
        s1.setLastName("Smith");
        s1.setGpa("4.0");
        s1.setMajor("EA");
        s1.setEmail("john@gmail.com");

        Student s2 = new Student();
        s2.setId(2L);
        s2.setFirstName("Richard");
        s2.setLastName("Smith");
        s2.setGpa("4.0");
        s2.setMajor("EA");
        s2.setEmail("richard@gmail.com");

//        adding course
        Course c1 = new Course();
        c1.setId(1L);
        c1.setName("EA");
        c1.setCode("543");

        Course c2 = new Course();
        c2.setId(2L);
        c2.setName("WAA");
        c2.setCode("545");


        List<Course> courseList = new ArrayList<>();
        courseList.add(c1);
        courseList.add(c2);
        s1.setCoursesTaken(courseList);

        studentsList.add(s1);
        studentsList.add(s2);
    }

    public List<Student> studentsList(){
        return studentsList;
    }

    public void save(Student student){
        studentsList.add(student);
    }

    public void update(Long id, Student updatedStudent) {
        //first find the student with given id
        Student existingStudent = studentsList.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (existingStudent != null) {
            // Update the properties of the existing student with the new values
            existingStudent.setFirstName(updatedStudent.getFirstName());
            existingStudent.setLastName(updatedStudent.getLastName());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setMajor(updatedStudent.getMajor());
            existingStudent.setGpa(updatedStudent.getGpa());
            existingStudent.setCoursesTaken(updatedStudent.getCoursesTaken());
        }
    }

    //Delete Student
    public void delete(Long id){
       studentsList.removeIf(student -> student.getId().equals(id));
    }

    public List<Student> getStudentByMajor(String major) {
        List<Student> studentsByMajor = new ArrayList<>();

        //filter to find students with the specified major
        studentsList.stream()
                .filter(student -> student.getMajor().equals(major))
                .forEach(studentsByMajor::add);

        return studentsByMajor;
    }

    //Get Courses By StudentID
    //Implement getCoursesByStudentId(int studentId) method.
    public List<Course> getCoursesByStudentId(Long studentId) {
        List<Course> coursesByStudentId = new ArrayList<>();

        // Use stream and filter to find the student by ID
        Student student = studentsList.stream()
                .filter(s -> s.getId() == studentId)
                .findFirst()
                .orElse(null);

        if (student != null) {
            // Get the courses taken by the student
            coursesByStudentId.addAll(student.getCoursesTaken());
        }

        return coursesByStudentId;
    }




}

