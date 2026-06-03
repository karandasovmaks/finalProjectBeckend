package com.samsung.postprojectshop.repository;

import com.samsung.postprojectshop.domain.Tests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Tests, Long> {
}
