package com.samsung.postprojectshop.rest.controller;

import com.samsung.postprojectshop.domain.Classes;
import com.samsung.postprojectshop.service.ClassesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ClassesController {

    private final ClassesService classesService;

    @PostMapping("classes")
    public Classes create(@RequestBody Map<String, Object> body) {
        String name = (String) body.get("name");
        Long teacherId = Long.valueOf(body.get("teacher_id").toString());
        return classesService.create(name, teacherId);
    }

    @GetMapping("classes/teacher/{teacherId}")
    public List<Classes> getByTeacher(@PathVariable Long teacherId) {
        return classesService.getByTeacherId(teacherId);
    }

    @GetMapping("classes/student/{studentId}")
    public List<Classes> getByStudent(@PathVariable Long studentId) {
        return classesService.getByStudentId(studentId);
    }

    @DeleteMapping("classes/{id}")
    public void delete(@PathVariable Long id) {
        classesService.delete(id);
    }
}
