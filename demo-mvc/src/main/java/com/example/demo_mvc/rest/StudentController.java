package com.example.demo_mvc.rest;

import com.example.demo_mvc.dao.StudentRepository;
import com.example.demo_mvc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentRepository studentRepository;
    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @GetMapping("/list")
    public String index(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "students";
    }
    @GetMapping("/create")
    public String create(Model model) {
    Student student = new Student();
    model.addAttribute("student", student);
    return "students-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student) {
        studentRepository.save(student);
        return "redirect:/students/list";
    }
    @GetMapping("/update")
    public String update(@RequestParam("id") Integer id, Model model) {
        Optional<Student> student = studentRepository.findById(id);
        model.addAttribute("student", student);
        return "students-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        studentRepository.deleteById(id);
        return "redirect:/students/list";
    }

}
