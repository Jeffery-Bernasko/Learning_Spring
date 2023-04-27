package com.bernasko.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
           Student Peter =  new Student(
                    "Peter",
                    "peter@email.com",
                    LocalDate.of(2000, Month.JANUARY,12)
            );

            Student Cedric =  new Student(
                    "Cedric",
                    "cedric@email.com",
                    LocalDate.of(2000, Month.APRIL,20)
            );

            Student Forgive =  new Student(
                    "Forgive",
                    "forgive@email.com",
                    LocalDate.of(2000, Month.FEBRUARY,12)
            );

            // Save into database
            studentRepository.saveAll(
                    List.of(Peter,Cedric,Forgive)
            );
        };
    }
}
