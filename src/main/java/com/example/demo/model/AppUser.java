package com.example.demo.model;

public class AppUser {

    private Long id;
    private String email;
    private String password;
    private String fullName;
    private UserRole role;

    public AppUser() {}

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public UserRole getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public void setRole(UserRole role) {
        this.role = role;
    }
}
