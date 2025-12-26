package com.example.demo.service;

import com.example.demo.dto.*;

public interface AuthService {
    AuthResponse register(RegisterRequest req);
    AuthResponse login(AuthRequest req);
}
