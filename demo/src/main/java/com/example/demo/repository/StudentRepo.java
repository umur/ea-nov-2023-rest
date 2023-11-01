package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    private static List<Student> students = new ArrayList<>();

    //create operation
    public void save (Student student){
        students.add(student);
    }
    public  List <Student> findAll(){
        return  students;
    }

    public Student findByID(int id){
        for(Student student:students){
            if(student.getId()== id){
                return  student;
            }
        }
        return null;
    }

    public void update(Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == updatedStudent.getId()) {
                students.set(i, updatedStudent);
                return; // Update the student and exit the loop
            }
        }
    }

    public void delete(int id) {
        students.removeIf(student -> student.getId() == id);
    }





}
