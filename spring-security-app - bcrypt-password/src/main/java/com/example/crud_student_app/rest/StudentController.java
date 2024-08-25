package com.example.crud_student_app.rest;

import com.example.crud_student_app.DAO.StudentDAOimpl;
import com.example.crud_student_app.entity.Student;
import com.example.crud_student_app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return this.studentService.getAllStudent();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        Student student =  studentService.getStudentById(id);
        if(student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        student =  studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}
