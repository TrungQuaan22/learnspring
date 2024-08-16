package com.example.create_project_JPA.dao;

import com.example.create_project_JPA.entity.SinhVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class SinhVienDAOimpl implements SinhVienDAO{
    private EntityManager em;
    @Autowired
    public SinhVienDAOimpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(SinhVien sinhVien) {
        this.em.persist(sinhVien);
    }

    @Override
    public SinhVien getById(int id) {
        return em.find(SinhVien.class, id);
    }

    @Override
    public List<SinhVien> getAll() {
        String jpql = "SELECT sv FROM SinhVien sv";
        TypedQuery<SinhVien> query = em.createQuery(jpql, SinhVien.class);
        return query.getResultList();
    }

    @Override
    public List<SinhVien> getByName(String name) {
        String jpql = "SELECT sv FROM SinhVien sv WHERE sv.ten = :name";
        TypedQuery<SinhVien> query = em.createQuery(jpql, SinhVien.class);
        return query.setParameter("name", name).getResultList();
    }

    @Override
    public SinhVien update(SinhVien sinhVien) {
        return this.em.merge(sinhVien);
    }

    @Override
    public int updateByName(String name) {
        String jpql = "UPDATE SinhVien s SET s.ten = :ten";
        Query query = this.em.createQuery(jpql, SinhVien.class);
        query.setParameter("ten", name);
        return query.executeUpdate();
    }

    @Override
    public void deleteByCondition(String condition) {
        String jpql = "DELETE FROM SinhVien s WHERE " + condition;
        Query query = this.em.createQuery(jpql);
        query.executeUpdate();
    }

}
