package com.samsung.postprojectshop.repository;

import com.samsung.postprojectshop.domain.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Long> {
    List<Classes> findByTeacherId(Long teacherId);

    Optional<Classes> findByCode(String code);

    boolean existsByCode(String code);

    @Query("SELECT c FROM Classes c JOIN ClassMembers cm ON c.id = cm.classId WHERE cm.studentId = :studentId")
    List<Classes> findClassesByStudentId(@Param("studentId") Long studentId);
}
