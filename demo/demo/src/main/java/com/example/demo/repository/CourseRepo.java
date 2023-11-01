package com.example.demo.repository;

import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Course;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CourseRepo {
    private static List<Course> courses = new ArrayList<>();
    private final ModelMapper modelMapper;

    public void save(Course course) {
        courses.add(course);
    }

    public List<CourseDto> getAll() {
        return courses.stream()
                .map(course -> modelMapper.map(course, CourseDto.class))
                .collect(Collectors.toList());
    }


    public Optional<Course> findById(int courseId) {
        return courses.stream().filter(course -> course.getId() == courseId).findFirst();
    }

    public void edit(int courseId, String name, String code) {
        Optional<Course> courseOptional = findById(courseId);
        courseOptional.ifPresent(course -> {
            course.setName(name);
            course.setCode(code);
        });
    }

    public void deleteCourse(int courseId) {
        courses.removeIf(course -> course.getId() == courseId);
    }


}
