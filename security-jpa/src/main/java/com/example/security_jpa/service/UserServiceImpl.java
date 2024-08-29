package com.example.security_jpa.service;

import com.example.security_jpa.dao.RoleRepository;
import com.example.security_jpa.dao.UserRepository;
import com.example.security_jpa.entity.Role;
import com.example.security_jpa.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    public User save(User user) {
        return userRepository.save(user);
    }
//    @PostConstruct
//    public void init() {
//        Role role1 = new Role();
//        role1.setName("ROLE_ADMIN");
//        roleRepository.save(role1);
//        Collection<Role> roles = new ArrayList<>();
//        roles.add(role1);
//        User user1 = new User();
//        user1.setUsername("admin");
//        user1.setPassword("$2a$12$eoHTU4ZZpKbUY0IVMFLZxeWkINMQ5kHDVt4THyYNZmzMt4AoVQSqa");
//        user1.setEnabled(true);
//        user1.setRoles(roles);
//        userRepository.save(user1);
//
//
//    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }else {
            return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), getAuthorities(user));
        }
    }
    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }
}
