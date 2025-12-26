package com.example.demo.repository;

import com.example.demo.model.*;
import java.util.*;
public interface AppUserRepository {
    Optional<AppUser> findByEmail(String email);
    AppUser save(AppUser user);
}