package com.samsung.postprojectshop.repository;

import com.samsung.postprojectshop.domain.Assignments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentsRepository extends JpaRepository<Assignments, Long> {
    List<Assignments> findByTeacherId(Long teacherId);

    @Query(value = "SELECT a.id, a.test_id, a.class_id, a.teacher_id FROM assignments a " +
            "JOIN class_members cm ON a.class_id = cm.class_id WHERE cm.student_id = :studentId",
            nativeQuery = true)
    List<Object[]> findAssignmentsByStudentId(@Param("studentId") Long studentId);

    long countByTestId(Long testId);
}
