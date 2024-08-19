package com.example.controller_advice_demo.rest;

import com.example.controller_advice_demo.entity.ErrorResponse;
import com.example.controller_advice_demo.entity.Student;
import com.example.controller_advice_demo.exception.StudentException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sinhvien")
public class StudentController {
    public List<Student> listStudent;
    @PostConstruct
    public void init() {
        listStudent = new ArrayList<>();
        listStudent.add(new Student("Nguyễn Văn", "A", 18, "woman", 2.3));
        listStudent.add(new Student("Trần Văn", "B", 18, "man", 2.5));
        listStudent.add(new Student("Nguyễn Văn", "Trỗi", 18, "man", 3.0));
        listStudent.add(new Student("Nguyễn Văn", "Bảy", 18, "woman", 3.2));
        listStudent.add(new Student("Lee Văn", "Tám", 18, "woman", 3.4));
    }
    @GetMapping("/")
    public List<Student> getListStudent() {
        return listStudent;
    }
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        Student sv = null;
        try{
            sv = listStudent.get(id - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new StudentException("Student not found with id " + id);
        }
        return sv;
    }


}
