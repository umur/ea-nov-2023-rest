package com.assignment.assignment1.service;

import com.assignment.assignment1.dto.FullStudentDto;
import com.assignment.assignment1.dto.PostStudentDto;

import java.util.List;

public interface StudentService {
    public FullStudentDto save(PostStudentDto postStudentDto);
    public List<FullStudentDto> findAll();
    public FullStudentDto findById(int id);
    public List<FullStudentDto> getStudentsByMajor(String major);
    public FullStudentDto delete(int id);
    public FullStudentDto put(int id, PostStudentDto postStudentDto);


}
