package com.example.springboot.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.AUGUST;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args ->{
                   Student navo = new Student(

                            "Navodya",
                            LocalDate.of(2000, AUGUST,5),
                            "navo@gmail.com"

                    );
            Student navo2 = new Student(

                    "Navodya2",
                    LocalDate.of(2005, AUGUST,5),
                    "navo2@gmail.com"

            );

            repository.saveAll(
                    List.of(
                            navo,
                            navo2
                    )
            );
        };
    }
}
