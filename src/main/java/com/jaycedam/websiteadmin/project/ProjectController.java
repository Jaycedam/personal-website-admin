package com.jaycedam.websiteadmin.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/projects")
@CrossOrigin("*")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getProjects() {
        return projectService.getProjects();
    }

    @PostMapping
    public void createStudent(@RequestBody Project project) {
        projectService.createProject(project);
    }

    @PutMapping(path = "update/{id}")
    public void updateProject(@PathVariable("id") Long id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String about,
                              @RequestParam(required = false) String url) {
        projectService.updateProject(id, name, about, url);

    }

    @DeleteMapping(path = "delete/{id}")
    public void deleteProject(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
    }

}
