package edu.ea.rest.service.impl;

import edu.ea.rest.dto.FullCourseDto;
import edu.ea.rest.model.Course;
import edu.ea.rest.repository.CourseRepo;
import edu.ea.rest.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl  implements CourseService {
    private final ModelMapper modelMapper;
    private  final CourseRepo courseRepo;



    private FullCourseDto mapper(Course course)
    {
        FullCourseDto  fullCourse = new FullCourseDto();
        modelMapper.map(course,fullCourse);
        return fullCourse;
    }

    private  Course mapper(FullCourseDto fullCourse)
    {
        Course  course = new  Course();
        modelMapper.map(fullCourse,course);
        return course;
    }
    @Override
    public List<FullCourseDto> findAll() {
        return courseRepo.findAll().stream().map(s-> mapper(s)).collect(Collectors.toList());
    }

    @Override
    public FullCourseDto findById(Integer id) throws Exception {
        Course course = courseRepo.findById(id);
        if(course==null)
            throw new Exception("Course not found");

        return mapper(course);
    }

    @Override
    public FullCourseDto addCourse(FullCourseDto fullCourseDto) {

        return mapper( courseRepo.addCourse(mapper(fullCourseDto)));
    }

    @Override
    public FullCourseDto update(Integer id, FullCourseDto fullCourse) throws Exception {
        Course courseOld = courseRepo.findById(fullCourse.getId());
        if(courseOld==null)
            throw new Exception("Course not exists");

        return   mapper(courseRepo.update(mapper(fullCourse)));

    }

    @Override
    public Boolean delete(Integer courseId) throws Exception {
        Course courseOld = courseRepo.findById(courseId);
        if(courseOld==null)
            throw new Exception("Course not exists");
        return courseRepo.delete(courseId);
    }
}
