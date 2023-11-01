package com.example.assignment1.repository;

import com.example.assignment1.domain.Student;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private static List<Student> students = new ArrayList<>();
    public List<Student>  findAll(){
        return students;
    }
    public void save(Student student) {
        students.add(student);
    }

    public Student update(int id, Student student){

        List<Student> updatedStudents = students.stream()
                .map(stu -> {
                    if (stu.getId() == id) {
                        return student;
                    } else {
                        return stu;
                    }
                }).collect(Collectors.toList());
        students = updatedStudents;
        Optional<Student> stus = students.stream().filter(stud ->stud.getId()==id).findFirst();
        return stus.get();
    }

    public void deleteStudent(int id){
        List<Student> updatedStudents = students.stream().filter(stu -> stu.getId() != id).collect(Collectors.toList());
        students = updatedStudents;
    }


}

