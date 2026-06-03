package com.samsung.postprojectshop.service;

import com.samsung.postprojectshop.domain.Classes;

import java.util.List;

public interface ClassesService {
    Classes create(String name, Long teacherId);

    Classes getById(Long id);

    List<Classes> getByTeacherId(Long teacherId);

    List<Classes> getByStudentId(Long studentId);

    Classes getByCode(String code);

    void delete(Long id);
}
