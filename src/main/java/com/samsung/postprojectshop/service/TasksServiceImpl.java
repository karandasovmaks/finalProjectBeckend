package com.samsung.postprojectshop.service;

import com.samsung.postprojectshop.domain.Tasks;
import com.samsung.postprojectshop.repository.TasksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TasksServiceImpl implements TasksService {

    private final TasksRepository tasksRepository;

    @Override
    public List<Tasks> getByTestId(Long testId) {
        return tasksRepository.findByTestId(testId);
    }

    @Override
    public Tasks getById(long id) {
        return tasksRepository.findById(id).orElseThrow(() ->
                new RuntimeException("task with id " + id + " was not found"));
    }

    @Override
    public Tasks create(Tasks task) {
        return tasksRepository.save(task);
    }
}
