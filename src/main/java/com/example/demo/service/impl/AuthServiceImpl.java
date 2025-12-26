package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthServiceImpl implements AuthService {

    private final AppUserRepository repo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager manager;
    private final JwtTokenProvider jwt;

    public AuthServiceImpl(AppUserRepository r, PasswordEncoder e,
                           AuthenticationManager m, JwtTokenProvider j) {
        this.repo = r; this.encoder = e; this.manager = m; this.jwt = j;
    }

    public AuthResponse register(RegisterRequest req) {
        AppUser user = AppUser.builder()
                .email(req.getEmail())
                .password(encoder.encode(req.getPassword()))
                .fullName(req.getFullName())
                .role(UserRole.CLINICIAN)
                .build();

        AppUser saved = repo.save(user);
        return new AuthResponse(saved.getEmail(), jwt.generateToken(saved));
    }

    public AuthResponse login(AuthRequest req) {
        manager.authenticate(
            new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
        );

        AppUser user = repo.findByEmail(req.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid"));

        return new AuthResponse(user.getEmail(), jwt.generateToken(user));
    }
}
