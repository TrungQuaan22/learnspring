package com.example.hibernate_advance.dao;

import com.example.hibernate_advance.entity.TeacherDetail;

public interface TeacherDetailDAO {
    public void save(TeacherDetail teacherDetail);
    public TeacherDetail findTeacherDetailById(int id);
    public void delete(TeacherDetail teacherDetail);
}
