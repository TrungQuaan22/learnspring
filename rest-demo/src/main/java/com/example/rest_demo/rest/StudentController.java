package com.example.rest_demo.rest;

import com.example.rest_demo.entity.Student;
import com.example.rest_demo.exception.StudentException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        Student sv = listStudent.get(id - 1);
        if(sv == null) {
            throw new StudentException("Student not found with id " + id);
        }
        return ResponseEntity.ok().body(sv);
    }

}
