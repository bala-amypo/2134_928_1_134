package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "app_users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long getId;

    @Column(nullable = false, unique = true)
    private String getEmail;

    @Column(nullable = false)
    private String getPassword;

    private String fullName;

    @Enumerated(EnumType.STRING)
    private UserRole getRole;
}
