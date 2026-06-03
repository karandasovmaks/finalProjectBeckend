package com.samsung.postprojectshop.service;

import com.samsung.postprojectshop.domain.User;

import java.util.List;

public interface UserService {
    User getById(long id);
    User create(User user);
    List<User> findByRoleLike(String role);
    boolean existsByUsername(String username);
    User findByUsername(String username);
}
