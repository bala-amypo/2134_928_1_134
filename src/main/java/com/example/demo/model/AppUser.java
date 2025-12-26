package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role;

    public AppUser() {}

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    // ===== BUILDER REQUIRED BY TESTS =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final AppUser u = new AppUser();

        public Builder id(Long id) {
            u.setId(id);
            return this;
        }

        public Builder username(String username) {
            u.setUsername(username);
            return this;
        }

        public Builder password(String password) {
            u.setPassword(password);
            return this;
        }

        public Builder role(String role) {
            u.setRole(role);
            return this;
        }

        public AppUser build() {
            return u;
        }
    }
}
