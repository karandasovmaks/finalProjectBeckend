package com.samsung.postprojectshop.service;

import com.samsung.postprojectshop.domain.Tests;
import com.samsung.postprojectshop.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServaiceImpl implements TestServaice{
    private final TestRepository testRepository;

    @Override
    public Tests getById(long id) {
        return testRepository.findById(id).orElseThrow(() ->
                new RuntimeException("test with id " + id + " was not found"));
    }

    @Override
    public List<Tests> getAll() {
        List<Tests> list = testRepository.findAll();
        return list;
    }

    @Override
    public Tests create(Tests tests) {
        return testRepository.save(tests);
    }
}
