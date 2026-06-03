package com.samsung.postprojectshop.service;

import com.samsung.postprojectshop.domain.ClassMembers;

public interface ClassMembersService {
    ClassMembers join(String code, Long studentId);

    void leave(Long classId, Long studentId);
}
