package com.example.mongodb_demo.service;

import com.example.mongodb_demo.entity.Student;
import com.example.mongodb_demo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository repository;

    public List<Student> GetStudentRecords() {
        return repository.findAll();
    }

    public String AddNewStudent(Student student) {

        Optional<Student> newStudentEmail = repository.findByEmail(student.getEmail());

        if (newStudentEmail.isPresent()) {

            throw new IllegalStateException("Email Address already exists");
        } else {

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.now();

            double random = ThreadLocalRandom.current().nextDouble(1000.00,5000.00);

            student.setUpdatedAt(dateTimeFormatter.format(localDateTime));
            student.setFeesBalance(Math.round(random));

            repository.save(student);
        }

        return "Entry Added";
    }

    public String UpdateStudentFees(String studentEmail, double feesBalance) {

        if (feesBalance >= 0) {

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.now();

            Student grabbedStudent = repository.findByEmail(studentEmail)
                    .orElseThrow(() -> new IllegalStateException("Email does not exist, Check email and try again"));

            grabbedStudent.setUpdatedAt(dateTimeFormatter.format(localDateTime));
            grabbedStudent.setFeesBalance(feesBalance);

            repository.save(grabbedStudent);

            System.out.println(grabbedStudent);

            return "Record Edited";
        }

        return "Something went wrong";
    }

    public String DeleteStudent(String studentEmail) {

        Student grabbedStudent = repository.findByEmail(studentEmail)
                .orElseThrow(() -> new IllegalStateException("Email of student does not exist"));

        Optional<Student> grabbedstudent2 = repository.findByEmail(studentEmail);

        System.out.println("Student class");
        System.out.println(grabbedStudent);

        System.out.println("");
        System.out.println("");

        System.out.println("Optional");
        System.out.println(grabbedstudent2);

        repository.deleteById(grabbedStudent.getId());

        return "Entry Deleted";
    }
}
