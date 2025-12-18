// File: AppUserController.java
package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AppUser;
import com.example.demo.service.AppUserService;

@RestController
@RequestMapping("/api/app-users")
public class AppUserController {

    private final AppUserService service;

    public AppUserController(AppUserService service) {
        this.service = service;
    }

    // CREATE USER
    @PostMapping
    public AppUser createUser(@RequestBody AppUser user) {
        return service.createUser(user);
    }

    // GET ALL USERS
    @GetMapping
    public List<AppUser> getAllUsers() {
        return service.getAllUsers();
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public AppUser getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    // GET USER BY EMAIL
    @GetMapping("/email/{email}")
    public AppUser getUserByEmail(@PathVariable String email) {
        return service.getUserByEmail(email);
    }
}
