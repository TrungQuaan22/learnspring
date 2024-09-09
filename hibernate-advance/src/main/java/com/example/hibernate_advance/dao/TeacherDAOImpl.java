package com.example.hibernate_advance.dao;

import com.example.hibernate_advance.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDAOImpl implements TeacherDAO{
    private EntityManager em;
    @Autowired
    public TeacherDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(Teacher teacher) {
        em.persist(teacher);
    }

    @Override
    public Teacher findTeacherById(int id) {
        return em.find(Teacher.class, id);
    }

    @Override
    public void delete(Teacher teacher) {
        Teacher teacher1 = em.find(Teacher.class, teacher.getId());
        if(teacher1 != null) {
            em.remove(teacher1);
        }
    }

    @Override
    @Transactional
    public void update(Teacher teacher) {
        em.merge(teacher);
        em.flush();
    }

}
