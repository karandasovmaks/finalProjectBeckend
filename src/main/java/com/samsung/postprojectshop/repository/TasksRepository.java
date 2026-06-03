package com.samsung.postprojectshop.repository;

import com.samsung.postprojectshop.domain.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {
    List<Tasks> findByTestId(Long testId);
}
