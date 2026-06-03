package com.samsung.postprojectshop.rest.controller;

import com.samsung.postprojectshop.domain.Tasks;
import com.samsung.postprojectshop.service.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TasksController {

    private final TasksService tasksService;

    @GetMapping("tasks")
    public List<Tasks> getByTestId(@RequestParam("test_id") Long testId) {
        return tasksService.getByTestId(testId);
    }

    @GetMapping("tasks/{id}")
    public Tasks getById(@PathVariable Long id) {
        return tasksService.getById(id);
    }

    @PostMapping("tasks")
    public Tasks create(@RequestBody Tasks task) {
        return tasksService.create(task);
    }
}
