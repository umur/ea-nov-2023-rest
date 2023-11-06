package com.example.RestFulllab.repository;

import com.example.RestFulllab.entity.Course;
import com.example.RestFulllab.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static List<Student> students = new ArrayList<>();

    public void save(Student student)
    {
        students.add(student);
    }

    public void addCourse(Student student, Course course)
    {
        student.getCoursesTaken().add(course);
        System.out.println("Students : "+ students );
    }
    public List<Student> getall()
    {
        System.out.println("Students : "+ students );
        return students;

    }

    public Optional<Student> getStudentById(int id)
    {
//        System.out.println("Students : "+ students );
        return students.stream().filter(stu->stu.getId()==id ).findFirst();
    }

    public Student updateStudent(int studentId, Student newStudent)
    {
        Optional<Integer> Opindex = students.stream().filter(student -> student.getId()==studentId).findFirst().map(students::indexOf);
        if(Opindex.isPresent())
        {
            int index=Opindex.get();
            students.set(index,newStudent);
        }
        return newStudent;
    }
    public void delete(int id)
    {
        students = students.stream().filter(student -> student.getId()!=id).toList();
    }

    public List<Student> getStudentsByMajor(String major)
    {
        List<Student> result= students.stream().filter(student ->
                student.getCoursesTaken().stream().anyMatch(course ->
                        course.getName().equals(major))).collect(Collectors.toList());
        return result;
    }

    public List<Course> getCoursesByStudentId(int id)
    {
        Optional<Student> OpStu = students.stream().filter(student -> student.getId()==id).findFirst();
        if(OpStu.isPresent())
        {
            return OpStu.get().getCoursesTaken();
        }
        throw new RuntimeException("Can not get Student For This Id");
    }

}
