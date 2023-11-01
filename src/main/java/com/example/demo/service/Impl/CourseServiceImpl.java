package com.example.demo.service.Impl;

import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepo;
import com.example.demo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {


    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> courseList = courseRepo.findAll();
        List<CourseDTO> courseDTOList = new ArrayList<>();
        courseList.forEach(course -> courseDTOList.add(modelMapper.map(course, CourseDTO.class)));
        return courseDTOList;
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        Optional<Course> course = courseRepo.findById(id);
        if (course.isPresent()) {
            return modelMapper.map(course.get(), CourseDTO.class);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id " + id);
        }
    }

    @Override
    public CourseDTO addCourse(CourseDTO courseDTO) {
        Course course = modelMapper.map(courseDTO, Course.class);
        course.setCreatedAt(LocalDateTime.now());
        Course savedCourse = courseRepo.save(course);
        return modelMapper.map(savedCourse, CourseDTO.class);
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        Optional<Course> course = courseRepo.findById(id);

        if (course.isPresent()) {
            Course courseToUpdate = modelMapper.map(courseDTO, Course.class);
            courseToUpdate.setUpdatedAt(LocalDateTime.now());
            courseToUpdate.setId(id);
            Course updatedCourse = courseRepo.update(courseToUpdate);
            return modelMapper.map(updatedCourse, CourseDTO.class);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id " + id);
        }
    }

    @Override
    public void deleteCourse(Long id) {
        Optional<Course> course = courseRepo.findById(id);
        if (course.isPresent()) {
            Course deletedCourse = course.get();
            deletedCourse.setDeleted(true);
            courseRepo.save(deletedCourse);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id " + id);
        }
    }
}

