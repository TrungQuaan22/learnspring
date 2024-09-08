package com.example.hibernate_advance.entity;

import jakarta.persistence.*;

import java.sql.Blob;
import java.sql.Date;

@Entity
@Table(name = "teacher_detail")
public class TeacherDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "birth-day")
    private Date dateOfBirth;
    @Column(name = "age")
    private int age;
    @Column(name = "gender")
    private boolean gender;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email", length = 256)
    private String email;
    @Column
    private double salary;
    @Column(name = "youtube_channel")
    private String youtubeChannel;
    @Column
    @Lob
    private Blob avatar;
    @OneToOne(mappedBy = "teacherDetail", cascade = CascadeType.ALL)
    private Teacher teacher;
    public TeacherDetail() {}

    public TeacherDetail(Date dateOfBirth, int age, boolean gender, String address, String phone, String email, double salary, String youtubeChannel, Blob avatar) {
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
        this.youtubeChannel = youtubeChannel;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "TeacherDetail{" +
                "id=" + id +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", avatar=" + avatar +
                '}';
    }
}
