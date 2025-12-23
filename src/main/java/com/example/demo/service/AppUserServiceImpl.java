package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AppUser;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AppUserRepository;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository repo;

    public AppUserServiceImpl(AppUserRepository repo) {
        this.repo = repo;
    }

    @Override
    public AppUser createUser(AppUser user) {
        return repo.save(user);
    }

    @Override
    public AppUser getUserById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User not found with id: " + id));
    }

    @Override
    public AppUser getUserByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User not found with email: " + email));
    }

    @Override
    public List<AppUser> getAllUsers() {
        return repo.findAll();
    }
}
