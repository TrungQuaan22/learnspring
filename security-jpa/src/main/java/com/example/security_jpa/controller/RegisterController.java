package com.example.security_jpa.controller;

import com.example.security_jpa.dao.RoleRepository;
import com.example.security_jpa.entity.Role;
import com.example.security_jpa.entity.User;
import com.example.security_jpa.service.UserService;
import com.example.security_jpa.web.RegisterUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("/register")
public class RegisterController {
    UserService userService;
    RoleRepository roleRepository;
    @Autowired
    public RegisterController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }
    @GetMapping("")
    public String register(Model model) {
        RegisterUser r = new RegisterUser();
        model.addAttribute("registerUser", r);
        return "register/register";
    }
    @PostMapping("/process")
    public String process(@Valid @ModelAttribute("registerUser") RegisterUser r,BindingResult bindingResult, Model model,
                           HttpSession session) {
        String username = r.getUsername();

        //form validation
        if(bindingResult.hasErrors()) {
            return "register/register";
        }

        //kiểm tra thông tin tồn tại
        User user = userService.findByUsername(username);
        if(user != null) {
            model.addAttribute("registerUser", new RegisterUser());
            model.addAttribute("my_error", "Tài khoản đã tồn tại");
            return "register/register";
        } else {
            User user1 = new User();
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user1.setUsername(r.getUsername());
            user1.setPassword(bCryptPasswordEncoder.encode(r.getPassword()));
            user1.setEmail(r.getEmail());
            user1.setFirstName(r.getFirstname());
            user1.setLastName(r.getLastname());
            Role defaultRole = roleRepository.findByName("ROLE_USER");
            Collection<Role> roles = new ArrayList<>();
            roles.add(defaultRole);
            user1.setRoles(roles);
            userService.save(user1);
            session.setAttribute("myuser", user1);
            return "register/confirmation";
        }
    }
    }

