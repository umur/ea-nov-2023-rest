package edu.miu.ea.rest.service.impl;

import edu.miu.ea.rest.model.RSStudent;
import edu.miu.ea.rest.model.dto.RSCourseDTO;
import edu.miu.ea.rest.model.dto.RSStudentDTO;
import edu.miu.ea.rest.repository.RSStudentRepository;
import edu.miu.ea.rest.service.RSStudentService;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RSStudentServiceImpl implements RSStudentService {

    private final RSStudentRepository repository;
    private final ModelMapper mapper;

    private RSStudent mapper(RSStudentDTO studentDTO) {

        RSStudent student = new RSStudent();

        mapper.map(studentDTO, student);

        return student;

    }

    private RSStudentDTO mapper(RSStudent student) {

        RSStudentDTO studentDTO = new RSStudentDTO();

        mapper.map(student, studentDTO);

        return studentDTO;

    }

    @Override
    public RSStudentDTO add(RSStudentDTO studentDTO) {

        RSStudent student = repository.addStudent(mapper(studentDTO));

        return mapper(student);

    }

    @Override
    public RSStudentDTO update(Integer id, RSStudentDTO studentDTO) throws Exception {

        RSStudent retrievedStudent = repository.findById(id);

        if (retrievedStudent != null) {
            throw new Exception("RSStudent not exist ");
        }

        return mapper(repository.update(mapper(studentDTO)));

    }

    @Override
    public List<RSStudentDTO> findAll() {

        return repository.findAll().stream().map(student -> mapper(student)).collect(Collectors.toList());

    }

    @Override
    public RSStudentDTO findById(Integer id) throws Exception {

        RSStudent student = repository.findById(id);

        if (student == null) {
            throw new Exception("RSStudent not exist");
        }

        return mapper(student);

    }

    @Override
    public List<RSStudentDTO> getStudentsByMajor(String major) {

        return repository.getStudentsByMajor(major).stream().map(student -> mapper(student)).collect(Collectors.toList());

    }

    @Override
    public List<RSCourseDTO> getCoursesByStudentId(int id) throws Exception {

        RSStudent student = repository.findById(id);

        if (student == null) {
            throw new Exception("RSStudent not exist");
        }

        return student.getCoursesTaken().stream().map(course -> {

            RSCourseDTO courseDTO = new RSCourseDTO();

            mapper.map(course, courseDTO);

            return courseDTO;

        }).collect(Collectors.toList());

    }

    @Override
    public Boolean retire(Integer id) throws Exception {

        RSStudent student = repository.findById(id);

        if (student != null) {
            throw new Exception("RSStudent not exist ");
        }

        return repository.retire(id);

    }

}
