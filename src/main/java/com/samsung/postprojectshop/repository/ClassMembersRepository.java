package com.samsung.postprojectshop.repository;

import com.samsung.postprojectshop.domain.ClassMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassMembersRepository extends JpaRepository<ClassMembers, Long> {
    Optional<ClassMembers> findByClassIdAndStudentId(Long classId, Long studentId);

    long countByClassId(Long classId);
}
