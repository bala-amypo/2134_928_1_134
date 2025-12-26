package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "app_users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String fullName;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    // ====== NO-ARGS CONSTRUCTOR ======
    public AppUser() {
    }

    // ====== BUILDER (MANUAL) ======
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final AppUser user = new AppUser();

        public Builder id(Long id) {
            user.setId(id);
            return this;
        }

        public Builder email(String email) {
            user.setEmail(email);
            return this;
        }

        public Builder password(String password) {
            user.setPassword(password);
            return this;
        }

        public Builder fullName(String fullName) {
            user.setFullName(fullName);
            return this;
        }

        public Builder role(UserRole role) {
            user.setRole(role);
            return this;
        }

        public AppUser build() {
            return user;
        }
    }

    // ====== GETTERS & SETTERS ======

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
