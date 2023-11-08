package edu.miu.ea.rest.repository;


import edu.miu.ea.rest.model.RSStudent;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RSStudentRepository {

    private final List<RSStudent> students = new ArrayList<>();

    @PostConstruct
    public void init() {

        RSStudent student = new RSStudent(
                1,
                "Osama",
                "Abdelhamid",
                "osamaahmed.abdelhamid@miu.edu",
                "ComPro",
                4.0, new ArrayList<>()
        );

        students.add(student);

    }

    public RSStudent addStudent(RSStudent student) {

        student.setId(students.size() + 1);

        students.add(student);

        return student;

    }

    public RSStudent update(RSStudent student) {

        RSStudent oldStudent = students.stream().filter(s -> s.getId() == student.getId() && !s.getRetired()).findAny().orElse(null);

        if (student != null) {
            oldStudent = student;
            return student;
        }

        return null;

    }

    public List<RSStudent> findAll() {

        return students.stream().filter(student -> !student.getRetired()).collect(Collectors.toList());

    }

    public RSStudent findById(Integer id) {

        return students.stream().filter(student -> student.getId() == id && !student.getRetired()).findAny().orElse(null);

    }

    public List<RSStudent> getStudentsByMajor(String major) {

        return students.stream().filter(student -> student.getMajor().equals(major)).collect(Collectors.toList());

    }

    public Boolean retire(Integer id) {

        RSStudent oldStudent = students.stream().filter(student -> student.getId() == id && !student.getRetired()).findAny().orElse(null);

        if (oldStudent != null) {
            oldStudent.setRetired(true);
            return true;
        }

        return false;

    }

}
