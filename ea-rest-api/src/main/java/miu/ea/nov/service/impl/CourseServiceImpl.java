package miu.ea.nov.service.impl;

import miu.ea.nov.entity.Course;
import miu.ea.nov.entity.Student;
import miu.ea.nov.payload.CourseDto;
import miu.ea.nov.repository.CourseRepository;
import miu.ea.nov.repository.StudentRepository;
import miu.ea.nov.service.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CourseServiceImpl(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }


    @Override
    public CourseDto createCourse(long studentId, CourseDto courseDto) {
        // Convert DTO to Entity
        Course course = mapToEntity(courseDto);

        // Retrieve Student entity by Id;
        Student student = studentRepository.findById(studentId);

        // Set course to Student entity
        course.setStudent(student);
       // Save course to the repository
        Course newCourse = courseRepository.save(course);
        return mapToDto(newCourse);
    }

    // Convert Entity to DTO
    private CourseDto mapToDto(Course course){
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        courseDto.setCode(course.getCode());
        return courseDto;
    }

    // Convert DTO to Entity
    private Course mapToEntity(CourseDto courseDto){
        Course course = new Course();
        course.setId(courseDto.getId());
        course.setName(courseDto.getName());
        course.setCode(courseDto.getCode());
        return course;
    }


} // End of CourseServiceImpl class
