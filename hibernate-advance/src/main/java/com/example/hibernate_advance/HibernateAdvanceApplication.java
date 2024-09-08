package com.example.hibernate_advance;

import com.example.hibernate_advance.dao.CourseDAO;
import com.example.hibernate_advance.dao.TeacherDAO;
import com.example.hibernate_advance.dao.TeacherDetailDAO;
import com.example.hibernate_advance.entity.Course;
import com.example.hibernate_advance.entity.Teacher;
import com.example.hibernate_advance.entity.TeacherDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HibernateAdvanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateAdvanceApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(CourseDAO courseDAO, TeacherDAO teacherDAO, TeacherDetailDAO teacherDetailDAO) {
		return runner -> {
			// createTeacher(teacherDAO);
			// findTeacherById(teacherDAO,1);
			// findTeacherDetailById(teacherDetailDAO, 1);
			createCourse(courseDAO, teacherDAO);
		};

	}

	private void createCourse(CourseDAO courseDAO, TeacherDAO teacherDAO) {
		Teacher teacher = new Teacher();
		teacher.setFirstName("Quan");
		teacher.setLastName("Giang Trung");
		TeacherDetail teacherDetail = new TeacherDetail();
		teacherDetail.setEmail("giangtrungquan01@gmail.com");
		teacherDetail.setAddress("403 Bach Mai");
		List<Course> courses = new ArrayList<>();
		Course course1 = new Course("Toán 12", "Boi duong hoc sinh gioi",null, null);
		Course course2 = new Course("Văn 12", "Boi duong hoc sinh gioi",null, null);
		courses.add(course1);
		courses.add(course2);
		teacher.setCourses(courses);
		teacherDAO.update(teacher);



	}

	private void findTeacherDetailById(TeacherDetailDAO teacherDetailDAO, int i) {
		TeacherDetail teacherDetail = teacherDetailDAO.findTeacherDetailById(i);
		System.out.println("TeacherDetail: " + teacherDetail);
		System.out.println("Teacher: " + teacherDetail.getTeacher());

	}

	private void findTeacherById(TeacherDAO teacherDAO, int id) {
		Teacher teacher = teacherDAO.findTeacherById(id);
		System.out.println("Teacher: " + teacher);
		System.out.println("TeacherDetail: "+teacher.getTeacherDetail());
	}

	private void createTeacher(TeacherDAO teacherDAO) {
		Teacher teacher = new Teacher();
		teacher.setFirstName("John");
		teacher.setLastName("Doe");
		TeacherDetail teacherDetail = new TeacherDetail();
		teacherDetail.setAddress("299 Hoang Mai");
		teacherDetail.setEmail("john.doe@gmail.com");
		teacherDetail.setGender(true);
		teacher.setTeacherDetail(teacherDetail);
		System.out.println("Saving teacher: " + teacher.getFirstName() + " " + teacher.getLastName());
		teacherDAO.save(teacher);
		System.out.println("Done");
	}
}
