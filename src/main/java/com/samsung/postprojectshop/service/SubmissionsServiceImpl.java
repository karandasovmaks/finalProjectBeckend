package com.samsung.postprojectshop.service;

import com.samsung.postprojectshop.domain.Submissions;
import com.samsung.postprojectshop.repository.SubmissionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubmissionsServiceImpl implements SubmissionsService {

    private final SubmissionsRepository submissionsRepository;

    @Override
    public Submissions create(Submissions submission) {
        return submissionsRepository.save(submission);
    }
}
