package com.samsung.postprojectshop.rest.controller;

import com.samsung.postprojectshop.domain.ClassMembers;
import com.samsung.postprojectshop.service.ClassMembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ClassMembersController {

    private final ClassMembersService classMembersService;

    @PostMapping("class-members/join")
    public ClassMembers join(@RequestBody Map<String, Object> body) {
        String code = (String) body.get("code");
        Long studentId = Long.valueOf(body.get("student_id").toString());
        return classMembersService.join(code, studentId);
    }

    @DeleteMapping("class-members")
    public void leave(@RequestParam("class_id") Long classId,
                      @RequestParam("student_id") Long studentId) {
        classMembersService.leave(classId, studentId);
    }
}
