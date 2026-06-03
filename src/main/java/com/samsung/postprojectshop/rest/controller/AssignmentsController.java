package com.samsung.postprojectshop.rest.controller;

import com.samsung.postprojectshop.domain.Assignments;
import com.samsung.postprojectshop.dto.AssignmentStudentView;
import com.samsung.postprojectshop.dto.AssignmentTeacherView;
import com.samsung.postprojectshop.service.AssignmentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AssignmentsController {

    private final AssignmentsService assignmentsService;

    @PostMapping("assignments")
    public Assignments create(@RequestBody Map<String, Object> body) {
        Long testId = Long.valueOf(body.get("test_id").toString());
        Long classId = Long.valueOf(body.get("class_id").toString());
        Long teacherId = Long.valueOf(body.get("teacher_id").toString());
        return assignmentsService.create(testId, classId, teacherId);
    }

    @GetMapping("assignments/teacher/{teacherId}")
    public List<AssignmentTeacherView> getForTeacher(@PathVariable Long teacherId) {
        return assignmentsService.getForTeacher(teacherId);
    }

    @GetMapping("assignments/student/{studentId}")
    public List<AssignmentStudentView> getForStudent(@PathVariable Long studentId) {
        return assignmentsService.getForStudent(studentId);
    }
}
