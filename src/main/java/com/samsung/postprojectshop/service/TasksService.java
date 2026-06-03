package com.samsung.postprojectshop.service;

import com.samsung.postprojectshop.domain.Tasks;

import java.util.List;

public interface TasksService {
    List<Tasks> getByTestId(Long testId);
    Tasks getById(long id);
    Tasks create(Tasks task);
}
