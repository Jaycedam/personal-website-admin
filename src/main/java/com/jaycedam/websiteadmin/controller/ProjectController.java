package com.jaycedam.websiteadmin.controller;

import com.jaycedam.websiteadmin.domain.Project;
import com.jaycedam.websiteadmin.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
@CrossOrigin("*")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(path = "projects")
    public List<Project> getProjects() {
        return projectService.getProjects();
    }

    @GetMapping(path = "projects/starred")
    public List<Project> getSwStarredProjects() {
        return projectService.getStarredProjects();
    }

    @PostMapping(path = "project/save")
    public void createProject(@RequestBody Project project) {
        projectService.createProject(project);
    }

    @PutMapping(path = "project/update/{id}")
    public void updateProject(@PathVariable("id") Long id,
                              @RequestBody Project newProject) {
        projectService.updateProject(id, newProject);

    }

    @DeleteMapping(path = "project/delete/{id}")
    public void deleteProject(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
    }

}
