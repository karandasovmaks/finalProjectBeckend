package com.samsung.postprojectshop.service;

import com.samsung.postprojectshop.domain.Assignments;
import com.samsung.postprojectshop.dto.AssignmentStudentView;
import com.samsung.postprojectshop.dto.AssignmentTeacherView;

import java.util.List;

public interface AssignmentsService {
    Assignments create(Long testId, Long classId, Long teacherId);

    List<AssignmentTeacherView> getForTeacher(Long teacherId);

    List<AssignmentStudentView> getForStudent(Long studentId);
}
