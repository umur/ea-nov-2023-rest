package edu.miu.ea.rest.service.impl;


import edu.miu.ea.rest.model.RSCourse;
import edu.miu.ea.rest.model.dto.RSCourseDTO;
import edu.miu.ea.rest.repository.RSCourseRepository;
import edu.miu.ea.rest.service.RSCourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RSCourseServiceImpl implements RSCourseService {

    private final RSCourseRepository repository;
    private final ModelMapper mapper;

    private RSCourse mapper(RSCourseDTO courseDTO) {

        RSCourse course = new RSCourse();

        mapper.map(courseDTO, course);

        return course;

    }

    private RSCourseDTO mapper(RSCourse course) {

        RSCourseDTO courseDTO = new RSCourseDTO();

        mapper.map(course, courseDTO);

        return courseDTO;

    }

    @Override
    public RSCourseDTO add(RSCourseDTO courseDTO) {

        return mapper(repository.addCourse(mapper(courseDTO)));

    }

    @Override
    public RSCourseDTO update(Integer id, RSCourseDTO courseDTO) throws Exception {

        RSCourse retrievedCourse = repository.findById(id);

        if (retrievedCourse == null) {
            throw new Exception("RSCourse not exist");
        }

        return mapper(repository.update(mapper(courseDTO)));

    }

    @Override
    public List<RSCourseDTO> findAll() {

        return repository.findAll().stream().map(course -> mapper(course)).collect(Collectors.toList());

    }

    @Override
    public RSCourseDTO findById(Integer id) throws Exception {

        RSCourse course = repository.findById(id);

        if (course == null) {
            throw new Exception("RSCourse not exist");
        }

        return mapper(course);

    }

    @Override
    public Boolean retire(Integer id) throws Exception {

        RSCourse course = repository.findById(id);

        if (course == null) {
            throw new Exception("RSCourse not exist");
        }

        return repository.retire(id);

    }

}
