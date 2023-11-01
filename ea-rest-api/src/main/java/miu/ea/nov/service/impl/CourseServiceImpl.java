package miu.ea.nov.service.impl;

import miu.ea.nov.entity.Course;
import miu.ea.nov.payload.CourseDto;
import miu.ea.nov.repository.CourseRepository;
import miu.ea.nov.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDto> findAll() {
        List<Course> courses = new ArrayList<Course>();
        List<CourseDto> result = new ArrayList<CourseDto>();
        courses.stream()
                .forEach(c -> {
                    result.add(new CourseDto().toDto(c));
                        });
        return result;
    }

//    public void create(CourseDto dto) {
//        var entity : Course = dto.toEntity();
//    }
}
