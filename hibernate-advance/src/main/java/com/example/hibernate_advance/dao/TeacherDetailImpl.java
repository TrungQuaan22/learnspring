package com.example.hibernate_advance.dao;

import com.example.hibernate_advance.entity.TeacherDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDetailImpl implements TeacherDetailDAO {
    private EntityManager em;
    @Autowired
    public TeacherDetailImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(TeacherDetail teacherDetail) {
        em.persist(teacherDetail);
    }

    @Override
    public TeacherDetail findTeacherDetailById(int id) {
        return em.find(TeacherDetail.class, id);
    }

    @Override
    public void delete(TeacherDetail teacherDetail) {
        TeacherDetail teacherDetail1 = em.find(TeacherDetail.class, teacherDetail.getId());
        if(teacherDetail1 != null) {
            em.remove(teacherDetail1);
        }
        else {
            System.out.println("Không tìm thấy sinh viên");
        }
    }
}
