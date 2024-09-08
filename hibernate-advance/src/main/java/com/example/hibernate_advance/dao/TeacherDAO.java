package com.example.hibernate_advance.dao;

import com.example.hibernate_advance.entity.Teacher;

public interface TeacherDAO {
    public void save(Teacher teacher);
    public Teacher findTeacherById(int id);
    public void delete(Teacher teacher);
    public void update(Teacher teacher);
}
