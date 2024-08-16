package com.example.create_project_JPA.dao;

import com.example.create_project_JPA.entity.SinhVien;

import java.util.List;

public interface SinhVienDAO {
    public void save(SinhVien sinhVien);
    public SinhVien getById(int id);
    public List<SinhVien> getAll();
    public List<SinhVien> getByName(String name);
    public SinhVien update(SinhVien sinhVien);
    public int updateByName(String name);
    public void deleteByCondition(String condition);
}
