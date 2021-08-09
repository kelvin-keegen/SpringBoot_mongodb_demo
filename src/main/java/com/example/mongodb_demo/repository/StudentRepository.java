package com.example.mongodb_demo.repository;

import com.example.mongodb_demo.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {

    Optional<Student>findByEmail(String email);

    Optional<Student>findById(String id);



}
