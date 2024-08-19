package com.example.crud_student_app.service;

import com.example.crud_student_app.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudent();
    public Student getStudentById(int id);
    public Student addStudent(Student student);
    public Student updateStudent(Student student);
    public void deleteStudent(int id);
}
