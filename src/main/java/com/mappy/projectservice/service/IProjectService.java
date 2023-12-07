package com.mappy.projectservice.service;

import com.mappy.projectservice.models.Project;

import java.util.Optional;

public interface IProjectService {
    Project save(Project project);
    Iterable<Project> getAll();
    Optional<Project> getById(Long id);
    Project update(Project project);
    void delete(Project project);
}
