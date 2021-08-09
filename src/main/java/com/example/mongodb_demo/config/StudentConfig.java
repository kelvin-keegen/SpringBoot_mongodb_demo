package com.example.mongodb_demo.config;

import com.example.mongodb_demo.entity.Address;
import com.example.mongodb_demo.entity.Gender;
import com.example.mongodb_demo.entity.Student;
import com.example.mongodb_demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class StudentConfig {


    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {

        return args -> {

            Address address = new Address(
                    "Kenya",
                    "00100",
                    "Nairobi"
            );

            String email = "kelvin@kmail.com";
            String time = LocalDateTime.now().toString();
            Student Kelvin = new Student(
                    "Kelvin",
                    "Keegan",
                    email,
                    Gender.MALE,
                    address,
                    time,
                    List.of("Math,CRE,GHC,BIO"),
                    1000.00
            );

            boolean demoStudent = repository.findByEmail(email).isPresent();

            if(!demoStudent) {

                repository.save(Kelvin);

            } else {

                System.out.println("We already have a testing element");

            }


        };

    }


}
