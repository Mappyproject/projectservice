package com.mappy.projectservice.controller;

import com.mappy.projectservice.dto.ProjectDto;
import com.mappy.projectservice.models.Project;
import com.mappy.projectservice.publisher.RabbitMQJsonProducer;
import com.mappy.projectservice.publisher.RabbitMQProducer;
import com.mappy.projectservice.service.ProjectService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    private final RabbitMQJsonProducer jsonProducer;

    @Autowired
    public ProjectController(ProjectService projectService, RabbitMQJsonProducer jsonProducer) { this.projectService = projectService; this.jsonProducer = jsonProducer; }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody ProjectDto projectDto) {
        jsonProducer.sendJsonMessage(projectDto);
        return ResponseEntity.ok("Project sent to RabbitMQ ...");
    }
    @GetMapping
    public Iterable<Project> getAll() { return projectService.getAll(); }
    @GetMapping(path= "/{projectId}")
    public Optional<Project> getById(@PathVariable Long projectId) { return projectService.getById(projectId); }
    @PostMapping
    public Project save(@RequestBody Project project) {
        ProjectDto projectDto = new ProjectDto(project.getId());
        sendJsonMessage(projectDto);
        return projectService.save(project); }
    @PutMapping
    public Project update(@RequestBody Project project) { return projectService.update(project); }
    @DeleteMapping
    public void delete(@RequestBody Project project) { projectService.delete(project); }
}
