package com.example.mongodb_demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private Gender gender;
    private Address address;
    private String UpdatedAt;
    private List<String> subjects;
    private double feesBalance;

    public Student(String firstName, String lastName, String email, Gender gender, Address address, String updatedAt, List<String> subjects, double feesBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        UpdatedAt = updatedAt;
        this.subjects = subjects;
        this.feesBalance = feesBalance;
    }

}
