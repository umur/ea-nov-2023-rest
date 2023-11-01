package com.example.lab1.myapp.service;

import com.example.lab1.myapp.dto.CourseDto;
import com.example.lab1.myapp.model.Course;
import com.example.lab1.myapp.repository.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CouseServiceImpl implements CourseService{
    private final CourseRepo CourseRepo;
    private final ModelMapper modelMapper;


    @Override
    public void save(Course course) {
        CourseRepo.save(course);
    }

    @Override
    public List<CourseDto> findAll() {
        List<Course> courses = CourseRepo.findAll();
        var result = new ArrayList<CourseDto>();
        courses.forEach(course -> {
            var dto = modelMapper.map(course, CourseDto.class);
            result.add(dto);
        });
        return result;
    }

    @Override
    public CourseDto findById(Integer id) {
        var course = CourseRepo.findById(id);
        var dto = modelMapper.map(course, CourseDto.class);
        return dto;
    }

    @Override
    public void delete(Integer id) {
        CourseRepo.delete(id);
    }

    @Override
    public void update(Integer id, CourseDto course) {
        var dto = modelMapper.map(course, Course.class);
        CourseRepo.update(id, dto);
    }
}
