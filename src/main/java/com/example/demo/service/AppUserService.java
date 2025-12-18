// File: AppUserService.java
package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AppUser;

public interface AppUserService {

    AppUser createUser(AppUser user);

    AppUser getUserById(Long id);

    AppUser getUserByEmail(String email);

    List<AppUser> getAllUsers();
}
