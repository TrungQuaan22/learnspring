package com.example.demo_mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.example.demo_mvc.entity.*;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
//    //Truy vấn bang firstname
//    public List<com.example.crud_student_app.entity.Student> findByFirstname(String firstName);
//    public List<com.example.crud_student_app.entity.Student> findByLastnameAndEmail(String lastname, String email);
//    @Query("SELECT ST FROM Student ST WHERE ST.firstname <> ?1")
//    public List<com.example.crud_student_app.entity.Student> findByNotEqualFirstname(String firstName);
}
