package miu.ea.nov.repository;

import miu.ea.nov.entity.Course;
import miu.ea.nov.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    // Hold data in array lists.
    private static final List<Student> students = new ArrayList<Student>();
    public List<Student> listStudent(){
        students.add(new Student(1L, "Geoffrey", "Opiyo",
        "dunky@mail.com", "Compro", 4.0, comproCourseList()));
        students.add(new Student(2L, "Hillary", "Arinda",
                "hillary@mail.com", "Compro", 4.0, comproCourseList()));
        students.add(new Student(3L, "Tonny", "Kakooza",
                "dunky@mail.com", "Compro", 4.0, comproCourseList()));
        students.add(new Student(4L, "Dianah", "Arinda",
                "dunky@mail.com", "MBA", 4.0, mbaCourseList()));
        return students;
    }

    private List<Course> mbaCourseList() {
        return CourseRepository.mbaCoursesList();
    }

    private List<Course> comproCourseList() {
        return CourseRepository.comproCoursesList();
    }

}
