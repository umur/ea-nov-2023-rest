package com.assignment.assignment1.repository;



import com.assignment.assignment1.entity.Course;
import com.assignment.assignment1.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {


    private  List<Student> students = new ArrayList<>();




    public List<Student> findAll() {
        return students;
    }

//    public Student findStudentById(int id){
//        Optional<Student> result = students
//                .stream()
//                .filter(s->s.getId()==id).findFirst();
//        return result.orElseThrow(()->new NoSuchElementException("No student found with ID: " + id));
//    }

    public void save(Student student){
        students.add(student);
    }
    public Student getStudentById(int id){
        for(Student std:students){
            if(std.getId()==id){
                return std;

            }
        }return null;
    }

    public List<Student> getStudentByMajor(String major){
       List<Student>studentByMajor=new ArrayList<>();
        for(Student std :students){
            if(std.getMajor().equalsIgnoreCase(major))
                studentByMajor.add(std);

        }
        return studentByMajor;
    }
    public List<Course>getCoursesByStudentId(int id){
        List<Course>coursesByStudent=new ArrayList<>();
        for(Student std:students){
            if(std.getId()==id){
                coursesByStudent.add((Course) std.getCourseTaken());
            }

        }return coursesByStudent;
    }
    public void delete(Student student){
        for(Student student1:students){
            if(student1==(student))
                students.remove(student);
            else return;
        }
    }
}
