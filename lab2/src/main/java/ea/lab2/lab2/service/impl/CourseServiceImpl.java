package ea.lab2.lab2.service.impl;

import ea.lab2.lab2.dto.FullCourseDto;
import ea.lab2.lab2.entity.Course;
import ea.lab2.lab2.repository.CourseRepository;
import ea.lab2.lab2.service.CourseServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseServices {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;


    @Override
    public void addCourse(Course course) {
        courseRepository.addCourse(course);
    }

    @Override
    public List<FullCourseDto> findAll() {
        List<Course> courseList = courseRepository.findAll();
        List<FullCourseDto> results = new ArrayList<>();

        courseList.forEach(course -> {
            FullCourseDto fullCourseDto = modelMapper.map(course,FullCourseDto.class);
            results.add(fullCourseDto);
        });
        return results;
    }
}
