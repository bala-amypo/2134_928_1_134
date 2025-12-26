package com.example.demo.repository;

import java.util.*;
public interface AppUserRepository {
    Optional<com.example.demo.model.AppUser> findByEmail(String email);
    com.example.demo.model.AppUser save(com.example.demo.model.AppUser user);
}