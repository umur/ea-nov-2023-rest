package edu.ea.rest.repository;

import edu.ea.rest.model.Course;
import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {

    private List<Course> courses;

    @PostConstruct
    private void init ()
    {
        courses= new ArrayList<>();
        courses.add( new Course(1,"Modern Programming Practices","CS401",false));
        courses.add( new Course(2,"Web Programming","CS472",false));
        courses.add( new Course(3,"Algorithms","CS435",false));
        courses.add( new Course(4,"Web Application Architecture","CS545",false));
        courses.add( new Course(5,"Software Architecture","CS590",false));
        courses.add( new Course(6,"Enterprise Architecture","CS544",false));


    }

    public List<Course>  findAll()
    {
        return courses.stream().filter(c -> !c.getDeleted()).collect(Collectors.toList());
    }

    public  Course   findById(Integer id)
    {
        return courses.stream().filter( c ->  c.getId()==id && !c.getDeleted()).findAny().orElse(null);
    }

    public Course addCourse(Course course)
    {
        course.setId(courses.size()+1);
        courses.add(course);
       return  course;

    }


     public Course update(Course course)
    {
        Course   courseOld =  courses.stream().filter( c ->  c.getId()==course.getId() && !c.getDeleted()).findAny().orElse(null);
        if(courseOld !=null) {
            courseOld = course;
         return    course;}
        else
            return  null;
    }

    public Boolean delete (Integer courseId)
    {
        Course   courseOld =  courses.stream().filter( c ->  c.getId()==courseId    && !c.getDeleted()).findAny().orElse(null);
        if(courseOld !=null) {
            courseOld.setDeleted(true);
            return    true;}
        else
            return  false;
    }

}
