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

    @GetMapping(path = "projects/software")
    public List<Project> getSwStarredProjects() {
        return projectService.getSwStarredProjects();
    }

    @GetMapping(path = "projects/motion")
    public List<Project> getMgStarredProjects() {
        return projectService.getMgStarredProjects();
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
