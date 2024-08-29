package com.example.security_jpa.web;

import jakarta.validation.constraints.*;

public class RegisterUser {
    @NotNull(message = "thông tin bắt buộc")
    @Size(min = 1, message = "thông tin bắt buộc")
    private String username;
    @NotNull(message = "thông tin bắt buộc")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).*$", message = "mật khẩu phải chứa ít nhất 1 ký tự đặc biệt, 1 chữ số, 1 chữ cái")
    private String password;

    private String firstname;
    private String lastname;
    @NotBlank
    @Email(message = "Email không hợp lệ")
    private String email;

    public RegisterUser() {
    }

    public RegisterUser(String username, String password, String firstname, String lastname, String email) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
