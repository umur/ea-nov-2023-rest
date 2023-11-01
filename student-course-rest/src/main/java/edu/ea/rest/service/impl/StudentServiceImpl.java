package edu.ea.rest.service.impl;

import edu.ea.rest.dto.FullCourseDto;
import edu.ea.rest.dto.FullStudentDto;
import edu.ea.rest.model.Student;
import edu.ea.rest.repository.StudentRepo;
import edu.ea.rest.service.StudentService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;

    private FullStudentDto mapper(Student student)
    {
        FullStudentDto fullStudentDto = new FullStudentDto();
        modelMapper.map(student, fullStudentDto);
        return fullStudentDto;
    }

    private  Student mapper(FullStudentDto fullStudentDto)
    {
        Student  student = new  Student();
        modelMapper.map(fullStudentDto,student);
        return student;
    }



    @Override
    public List<FullStudentDto> findAll() {

        return studentRepo.findAll().stream().map(
                s -> mapper(s)).collect(Collectors.toList());
    }

    @Override
    public FullStudentDto findById(Integer id) throws Exception {
       Student student = studentRepo.findById(id);
        if(student==null)
         throw  new Exception("Student not Found");
        return mapper(student);
    }

    @Override
    public FullStudentDto addStudent(FullStudentDto fullStudentDto)  {

       Student student= studentRepo.addStudent(mapper(fullStudentDto));

        return mapper(student);
    }

    @Override
    public FullStudentDto update(Integer id, FullStudentDto fullStudentDto) throws Exception {
        Student studentExist = studentRepo.findById(id);
        fullStudentDto.setId(id);
        if(studentExist!=null)
            throw  new Exception("Student not exists ");
        Student update = studentRepo.update(mapper(fullStudentDto));
        return mapper(update);
    }

    @Override
    public Boolean deleteStudent(Integer id) throws Exception {
        Student studentExist = studentRepo.findById(id);

        if(studentExist!=null)
            throw  new Exception("Student not exists ");
        return studentRepo.deleteStudent(id);
    }

    @Override
    public List<FullStudentDto> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major).stream().map(s-> mapper(s)).collect(Collectors.toList());
    }

    @Override
    public List<FullCourseDto> getCoursesByStudentId(int studentId) throws Exception {

        Student student = studentRepo.findById(studentId);
        if(student==null)
            throw  new Exception("Student not Found");
        return student.getCoursesTaken().stream().map(c -> {
            FullCourseDto fc =new FullCourseDto();
            modelMapper.map(c,fc);
            return  fc;
        }).collect(Collectors.toList());
    }


}
