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
        students.add(new Student(1L, "Geoffrey", "Opiyo", "dunky@mail.com",
                "Compro", 4.0, comproCourseList()));
        students.add(new Student(2L, "Hillary", "Arinda", "hillary@mail.com",
                "Compro", 4.0, comproCourseList()));
        students.add(new Student(3L, "Tonny", "Kakooza", "toni@mail.com",
                "Compro", 4.0, comproCourseList()));
        students.add(new Student(4L, "Dianah", "Arinda", "dianah@mail.com",
                "MBA", 4.0, comproCourseList()));
        return students;
    }

    private List<Course> comproCourseList() {
        return CourseRepository.comproCoursesList();
    }

    public Student save(Student student){
        List<Student> newStudents = new ArrayList<Student>();
        newStudents.add(student);
        return student;
    }

    public List<Student> findAllStudent(){
        return listStudent();
    }

    public Student findById(long id) {
        List<Student> list = listStudent();
        for (Student student : list) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public List<Student> findByMajor(String major) {
        List<Student> list = listStudent();
        List<Student> newList = new ArrayList<Student>();
        for (Student student : list) {
            if (student.getMajor().equals(major)) {
                newList.add(student);
                return newList;
            }
        }
        return null;
    }

    public void delete(long id){
        List<Student> list = listStudent();
        for (int i = 0; i < list.size(); i++ ) {
            if (list.get(i).getId() == id) {
                list.remove(i);
            }
        }

    }

} // End of Student repository class
