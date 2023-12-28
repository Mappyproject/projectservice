package com.mappy.projectservice.controller;

import com.mappy.projectservice.models.Project;
import com.mappy.projectservice.service.ProjectService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class ProjectController {
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) { this.projectService = projectService; }

    @GetMapping
    public Iterable<Project> getAll() { return projectService.getAll(); }
    @GetMapping(path= "/{projectId}")
    public Optional<Project> getById(@PathVariable Long projectId) { return projectService.getById(projectId); }
    @PostMapping
    public Project save(@RequestBody Project project) { return projectService.save(project); }
    @PutMapping
    public Project update(@RequestBody Project project) { return projectService.update(project); }
    @DeleteMapping
    public void delete(@RequestBody Project project) { projectService.delete(project); }
}
