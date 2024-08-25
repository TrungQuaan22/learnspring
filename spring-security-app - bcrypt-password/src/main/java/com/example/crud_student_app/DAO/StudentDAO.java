package com.example.crud_student_app.DAO;

import com.example.crud_student_app.entity.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> findAll();
    public Student getById(int id);
    public Student save(Student student);
    //update
    public Student saveAndFlush(Student student);
    public void deleteById(int id);

}
