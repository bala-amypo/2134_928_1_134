package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class AuthResponse {
    private String email;
    private String token;
}
