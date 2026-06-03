package com.samsung.postprojectshop.repository;

import com.samsung.postprojectshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRoleLike(String role);
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
