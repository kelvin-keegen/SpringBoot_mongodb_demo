package com.example.mongodb_demo.controller;

import com.example.mongodb_demo.entity.Student;
import com.example.mongodb_demo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping
public class StudentController {

    private final StudentService studentService;

    @GetMapping(path = "/all")
    public List<Student> GetallData() {
       return studentService.GetStudentRecords();
    }

    @PostMapping(path = "/add")
    public String RegisterData(@RequestBody Student student){

        return studentService.AddNewStudent(student);
    }

    @PutMapping(path = "/edit/{studentEmail}")
    public String EditFeesBalance(
            @PathVariable("studentEmail")String studentEmail,
            @RequestParam(required = true)double feesBalance) {

        return studentService.UpdateStudentFees(studentEmail,feesBalance);

    }

    @DeleteMapping(path = "/delete/{studentEmail}")
    public String DeleteStudentEntry(
            @PathVariable("studentEmail")String studentEmail
    ) {
        return studentService.DeleteStudent(studentEmail);
    }

}
