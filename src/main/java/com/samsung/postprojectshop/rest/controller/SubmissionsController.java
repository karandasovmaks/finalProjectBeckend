package com.samsung.postprojectshop.rest.controller;

import com.samsung.postprojectshop.domain.Submissions;
import com.samsung.postprojectshop.service.SubmissionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SubmissionsController {

    private final SubmissionsService submissionsService;

    @PostMapping("submissions")
    public Submissions create(@RequestBody Submissions submission) {
        return submissionsService.create(submission);
    }
}
