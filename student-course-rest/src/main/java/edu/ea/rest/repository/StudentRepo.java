package edu.ea.rest.repository;

import edu.ea.rest.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {

    private List<Student> students  ;

    @PostConstruct
    public void init ()
    {   students = new ArrayList<>();
        students.add(    new Student(1,"Ibrahim","Abu Hdaib","iabuhdaib@miu.edu","Compro",3.5,false,new ArrayList<>()));
    }

    public List<Student> findAll()
    {
        return students.stream().filter(s->!s.getDeleted()).collect(Collectors.toList());
    }

    public Student findById(Integer id )
    {
      return   students.stream().filter(s -> s.getId()==id && !s.getDeleted()).findAny().orElse(null);
    }

    public Student addStudent(Student student)
    { student.setId(students.size()+1);
        students.add(student);
        return student;
    }

    public Student update(Student student )
    {
        Student studentOld=students.stream().filter(s -> s.getId()==student.getId() && !s.getDeleted()).findAny().orElse(null);
        if (student!=null) {
            studentOld = student;
            return student;
        }
        else
            return  null;
    }

    public Boolean deleteStudent(Integer id)
    {
        Student studentOld=students.stream().filter(s -> s.getId()==id && !s.getDeleted()).findAny().orElse(null);
        if (studentOld!=null) {
            studentOld.setDeleted(true);
            return true;
        }
        else
            return  false;
    }

    public   List<Student> getStudentsByMajor(String major)
    {
       return students.stream().filter(s ->s.getMajor().equals(major)).collect(Collectors.toList());
    }
}
