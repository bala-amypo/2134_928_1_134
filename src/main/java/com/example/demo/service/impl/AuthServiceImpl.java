package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.model.*;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthServiceImpl implements AuthService {

    private final AppUserRepository repo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtTokenProvider jwt;

    public AuthServiceImpl(
            AppUserRepository repo,
            PasswordEncoder encoder,
            AuthenticationManager authManager,
            JwtTokenProvider jwt) {
        this.repo = repo;
        this.encoder = encoder;
        this.authManager = authManager;
        this.jwt = jwt;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {

        AppUser user = new AppUser();
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setFullName(request.getFullName());
        user.setRole(UserRole.CLINICIAN);

        AppUser saved = repo.save(user);
        return new AuthResponse(saved.getEmail(), jwt.generateToken(saved));
    }

    @Override
    public AuthResponse login(AuthRequest request) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        AppUser user = repo.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user"));

        return new AuthResponse(user.getEmail(), jwt.generateToken(user));
    }
}
