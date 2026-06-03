package com.samsung.postprojectshop.repository;

import com.samsung.postprojectshop.domain.Submissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionsRepository extends JpaRepository<Submissions, Long> {
    @Query("SELECT COUNT(s) FROM Submissions s WHERE s.assignment_id = :assignmentId")
    long countByAssignmentId(@Param("assignmentId") Long assignmentId);

    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM Submissions s WHERE s.assignment_id = :assignmentId AND s.student_id = :studentId")
    boolean existsByAssignmentIdAndStudentId(@Param("assignmentId") Long assignmentId, @Param("studentId") Long studentId);
}
