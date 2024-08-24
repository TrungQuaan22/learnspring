package com.example.crud_student_app.rest;

import com.example.crud_student_app.DAO.StudentRepository;
import com.example.crud_student_app.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class StudentController2 {
    private StudentRepository studentRepository;
    @Autowired
    public StudentController2(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @GetMapping("/firstname/{firstname}")
    public List<Student> getStudentByFirstname(@PathVariable String firstname) {
        return  studentRepository.findByNotEqualFirstname(firstname);
    }
}
