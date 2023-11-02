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
    static Student student1 = new Student(1L, "Geoffrey", "Opiyo", "dunky@mail.com",
            "Compro", 4.0, comproCourseList());
    static Student student2 = new Student(2L, "Hillary", "Arinda", "hillary@mail.com",
            "Compro", 4.0, comproCourseList());
    static Student student3 = new Student(3L, "Tonny", "Kakooza", "toni@mail.com",
            "Compro", 4.0, comproCourseList());
    static Student student4 = new Student(4L, "Dianah", "Arinda", "dianah@mail.com",
            "MBA", 4.0, comproCourseList());
    public List<Student> listStudent(){
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        return students;
    }

    private static List<Course> comproCourseList() {
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
