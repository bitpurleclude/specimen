package com.specimen.www;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.specimen.www.mapper")
public class SpecimenApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpecimenApplication.class, args);
    }

}
