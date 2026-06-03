package com.samsung.postprojectshop.service;

import com.samsung.postprojectshop.domain.Classes;
import com.samsung.postprojectshop.repository.ClassesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ClassesServiceImpl implements ClassesService {

    private static final String CODE_CHARS = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
    private static final int CODE_LENGTH = 9;
    private final Random random = new Random();

    private final ClassesRepository classesRepository;

    private String generateCode() {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            code.append(CODE_CHARS.charAt(random.nextInt(CODE_CHARS.length())));
        }
        return code.toString();
    }

    @Override
    public Classes create(String name, Long teacherId) {
        String code;
        do {
            code = generateCode();
        } while (classesRepository.existsByCode(code));

        Classes cls = Classes.builder()
                .name(name)
                .code(code)
                .teacherId(teacherId)
                .build();
        return classesRepository.save(cls);
    }

    @Override
    public Classes getById(Long id) {
        return classesRepository.findById(id).orElseThrow(() ->
                new RuntimeException("class with id " + id + " was not found"));
    }

    @Override
    public List<Classes> getByTeacherId(Long teacherId) {
        return classesRepository.findByTeacherId(teacherId);
    }

    @Override
    public List<Classes> getByStudentId(Long studentId) {
        return classesRepository.findClassesByStudentId(studentId);
    }

    @Override
    public Classes getByCode(String code) {
        return classesRepository.findByCode(code).orElseThrow(() ->
                new RuntimeException("class with code " + code + " was not found"));
    }

    @Override
    public void delete(Long id) {
        classesRepository.deleteById(id);
    }
}
