package com.example.crud_student_app.DAO;

import com.example.crud_student_app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //Truy vấn bang firstname
   public List<Student> findByFirstname(String firstName);
   public List<Student> findByLastnameAndEmail(String lastname, String email);
   @Query("SELECT ST FROM Student ST WHERE ST.firstname <> ?1")
    public List<Student> findByNotEqualFirstname(String firstName);
}
