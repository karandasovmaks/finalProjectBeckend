package com.samsung.postprojectshop.rest.controller;

import com.samsung.postprojectshop.domain.Tests;
import com.samsung.postprojectshop.service.TestServaice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestServaice testServaice;

    @GetMapping("tests/{id}")
    public Tests getTestById(@PathVariable Long id) {
        return testServaice.getById(id);
    }

    @GetMapping("tests")
    public List<Tests> getAlltests() {
        return testServaice.getAll();
    }

    @PostMapping("tests")
    public Tests postTest(@RequestBody Tests tests) {
        return testServaice.create(tests);
    }
}
