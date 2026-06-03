package com.samsung.postprojectshop.service;

import com.samsung.postprojectshop.domain.ClassMembers;
import com.samsung.postprojectshop.domain.Classes;
import com.samsung.postprojectshop.repository.ClassMembersRepository;
import com.samsung.postprojectshop.repository.ClassesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassMembersServiceImpl implements ClassMembersService {

    private final ClassMembersRepository classMembersRepository;
    private final ClassesRepository classesRepository;

    @Override
    public ClassMembers join(String code, Long studentId) {
        Classes cls = classesRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("class with code " + code + " was not found"));

        ClassMembers member = ClassMembers.builder()
                .classId(cls.getId())
                .studentId(studentId)
                .build();
        return classMembersRepository.save(member);
    }

    @Override
    public void leave(Long classId, Long studentId) {
        classMembersRepository.findByClassIdAndStudentId(classId, studentId)
                .ifPresent(classMembersRepository::delete);
    }
}
