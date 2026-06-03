package com.samsung.postprojectshop.service;

import com.samsung.postprojectshop.domain.Tests;
import com.samsung.postprojectshop.domain.User;

import java.util.List;

public interface TestServaice {
    Tests getById(long id);
    List<Tests> getAll();
    Tests create(Tests tests);
}
