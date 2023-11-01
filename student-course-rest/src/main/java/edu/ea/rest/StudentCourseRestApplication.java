package edu.ea.rest;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentCourseRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentCourseRestApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper()
    {
        return  new ModelMapper();
    }

}
