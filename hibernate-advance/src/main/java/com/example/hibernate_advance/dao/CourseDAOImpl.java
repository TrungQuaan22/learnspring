package com.example.hibernate_advance.dao;

import com.example.hibernate_advance.entity.Course;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDAOImpl implements CourseDAO {
    private EntityManager em;
    @Autowired
    public CourseDAOImpl(EntityManager em) {
        this.em = em;
    }
    @Override
    public void save(Course course) {
        em.persist(course);
    }
}
