package com.assignment.assignment1.service.impl;

import com.assignment.assignment1.domain.Course;
import com.assignment.assignment1.dto.FullCourseDto;
import com.assignment.assignment1.repository.CourseRepo;
import com.assignment.assignment1.repository.StudentRepo;
import com.assignment.assignment1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;

    @Override
    public FullCourseDto save(FullCourseDto courseDto) {
        Course course = modelMapper.map(courseDto, Course.class);
        course.setDeleted(false);
        return modelMapper.map(courseRepo.save(course), FullCourseDto.class);
    }

    @Override
    public List<FullCourseDto> findAll() {
        List<Course> courseList = courseRepo.findAll();
        return courseList.stream()
                .map(c -> modelMapper.map(c, FullCourseDto.class))
                .toList();
    }

    @Override
    public FullCourseDto findById(int id) {
        Optional<Course> optionalCourse = courseRepo.findById(id);
        if(optionalCourse.isPresent()){
            return modelMapper.map(optionalCourse, FullCourseDto.class);
        }
        return null;
    }
    @Override
    public List<FullCourseDto> getCoursesByStudentId(int id) {
        return studentRepo.getCoursesByStudentId(id).stream()
                .map(c -> modelMapper.map(c, FullCourseDto.class))
                .toList();
    }

    @Override
    public FullCourseDto delete(int id) {
        Optional<Course> optionalCourse = courseRepo.delete(id);
        if(optionalCourse.isPresent()){
            return modelMapper.map(optionalCourse, FullCourseDto.class);
        }
        return null;
    }

    @Override
    public FullCourseDto put(int id, FullCourseDto courseDto) {
        Optional<Course> optionalCourse = courseRepo.put(id, modelMapper.map(courseDto, Course.class));
        if(optionalCourse.isPresent()){
            return modelMapper.map(optionalCourse, FullCourseDto.class);
        }
        return null;
    }
}
