package com.samsung.postprojectshop.service;

import com.samsung.postprojectshop.domain.Assignments;
import com.samsung.postprojectshop.domain.Classes;
import com.samsung.postprojectshop.domain.Tests;
import com.samsung.postprojectshop.domain.User;
import com.samsung.postprojectshop.dto.AssignmentStudentView;
import com.samsung.postprojectshop.dto.AssignmentTeacherView;
import com.samsung.postprojectshop.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentsServiceImpl implements AssignmentsService {

    private final AssignmentsRepository assignmentsRepository;
    private final TestRepository testRepository;
    private final ClassesRepository classesRepository;
    private final UserRepository userRepository;
    private final SubmissionsRepository submissionsRepository;
    private final ClassMembersRepository classMembersRepository;

    @Override
    public Assignments create(Long testId, Long classId, Long teacherId) {
        Assignments assignment = Assignments.builder()
                .testId(testId)
                .classId(classId)
                .teacherId(teacherId)
                .build();
        return assignmentsRepository.save(assignment);
    }

    @Override
    public List<AssignmentTeacherView> getForTeacher(Long teacherId) {
        List<Assignments> assignments = assignmentsRepository.findByTeacherId(teacherId);
        List<AssignmentTeacherView> result = new ArrayList<>();

        for (Assignments a : assignments) {
            Tests test = testRepository.findById(a.getTestId()).orElse(null);
            Classes cls = classesRepository.findById(a.getClassId()).orElse(null);

            int submittedCount = (int) submissionsRepository.countByAssignmentId(a.getId());
            int totalCount = (int) classMembersRepository.countByClassId(a.getClassId());

            result.add(new AssignmentTeacherView(
                    a.getId(),
                    a.getTestId(),
                    test != null ? test.getName() : "Unknown",
                    test != null ? test.getDescription() : "",
                    cls != null ? cls.getName() : "Unknown",
                    a.getClassId(),
                    submittedCount,
                    totalCount
            ));
        }

        return result;
    }

    @Override
    public List<AssignmentStudentView> getForStudent(Long studentId) {
        List<Object[]> rows = assignmentsRepository.findAssignmentsByStudentId(studentId);
        List<AssignmentStudentView> result = new ArrayList<>();

        for (Object[] row : rows) {
            Long assignId = ((Number) row[0]).longValue();
            Long testId = ((Number) row[1]).longValue();
            Long classId = ((Number) row[2]).longValue();
            Long teacherId = ((Number) row[3]).longValue();

            Tests test = testRepository.findById(testId).orElse(null);
            Classes cls = classesRepository.findById(classId).orElse(null);
            User teacher = userRepository.findById(teacherId).orElse(null);

            boolean submitted = submissionsRepository.existsByAssignmentIdAndStudentId(assignId, studentId);

            result.add(new AssignmentStudentView(
                    assignId,
                    testId,
                    test != null ? test.getName() : "Unknown",
                    test != null ? test.getDescription() : "",
                    cls != null ? cls.getName() : "Unknown",
                    teacher != null ? teacher.getUsername() : "Unknown",
                    teacherId,
                    submitted
            ));
        }

        return result;
    }
}
