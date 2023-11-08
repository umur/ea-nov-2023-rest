package edu.miu.ea.rest.repository;


import edu.miu.ea.rest.model.RSCourse;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RSCourseRepository {

    private final List<RSCourse> courses = new ArrayList<>();

    @PostConstruct
    private void init() {
        courses.add(new RSCourse(1, "STC Pt 1- ComPro (Science and Technology of Consciousness)", "STC506A"));
        courses.add(new RSCourse(2, "Compro Entry Group", "Entry"));
        courses.add(new RSCourse(3, "Modern Programming Practices", "CS401"));
        courses.add(new RSCourse(4, "Big Data Technology", "CS523"));
        courses.add(new RSCourse(5, "Web Programming", "CS472"));
        courses.add(new RSCourse(6, "Enterprise Architecture", "CS544"));
        courses.add(new RSCourse(7, "Algorithms", "CS435"));
        courses.add(new RSCourse(8, "Career Strategies for Information Technology", "MGT5341"));
        courses.add(new RSCourse(9, "STC Pt2 Leadership for Tech Managers", "STC506B"));
    }

    public RSCourse addCourse(RSCourse course) {

        course.setId(courses.size() + 1);

        courses.add(course);

        return course;

    }

    public RSCourse update(RSCourse course) {

        RSCourse oldCourse = courses.stream().filter(c -> c.getId() == course.getId() && !c.getRetired()).findAny().orElse(null);

        if (oldCourse != null) {
            oldCourse = course;
            return course;
        }

        return null;

    }

    public List<RSCourse> findAll() {

        return courses.stream().filter(course -> !course.getRetired()).collect(Collectors.toList());

    }

    public RSCourse findById(Integer id) {

        return courses.stream().filter(course -> course.getId() == id && !course.getRetired()).findAny().orElse(null);

    }

    public Boolean retire(Integer id) {

        RSCourse oldCourse = courses.stream().filter(course -> course.getId() == id && !course.getRetired()).findAny().orElse(null);

        if (oldCourse != null) {
            oldCourse.setRetired(true);
            return true;
        }

        return false;

    }

}
