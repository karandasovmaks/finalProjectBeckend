package com.samsung.postprojectshop.service;

import com.samsung.postprojectshop.domain.User;
import com.samsung.postprojectshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServicelmpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getById(long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("user with id " + id + " was not found"));
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findByRoleLike(String role) {
        return userRepository.findByRoleLike(role);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() ->
                new RuntimeException("user with username " + username + " was not found"));
    }
}
