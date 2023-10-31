package com.assginments.lab2;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Lab2Config {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
