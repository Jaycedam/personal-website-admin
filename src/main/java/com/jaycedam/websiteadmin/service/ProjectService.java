package com.jaycedam.websiteadmin.service;

import com.jaycedam.websiteadmin.domain.Project;
import com.jaycedam.websiteadmin.repo.AreaRepository;
import com.jaycedam.websiteadmin.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final AreaRepository areaRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, AreaRepository areaRepository) {
        this.projectRepository = projectRepository;
        this.areaRepository = areaRepository;
    }

    // CRUD
    public List<Project> getProjects() {
        return projectRepository.findAllProjects();
    }

    public List<Project> getSwStarredProjects() {
        return projectRepository.findAllSwStarredProjects();
    }

    public List<Project> getMgStarredProjects() {
        return projectRepository.findAllMgStarredProjects();
    }

    public void createProject(Project project) {
        // Checks for area FK before creating project
        if(project.getArea() != null) {
            areaRepository.findById(project.getArea().getId()).orElseThrow(() -> new IllegalStateException(
                    "Area with id " + project.getArea().getId() + " doesn't exist."
            ));
        }

        projectRepository.save(project);
    }

    @Transactional
    public void updateProject(Long id,
                              Project newProject) {

        // Check if Project exist by id
        Project project = projectRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Project with id " + id + "doesn't exist."
        ));

        // Check if Area exist by id
        if(newProject.getArea() != null) {
            areaRepository.findById(newProject.getArea().getId()).orElseThrow(() -> new IllegalStateException(
                    "Area doesn't exist."
            ));
            project.setArea(newProject.getArea());
        }

        if(newProject.getName() != null && newProject.getName().length() > 0 &&
        !Objects.equals(project.getName(), newProject.getName())) {
            project.setName(newProject.getName());
        }

        if(newProject.getTechnology() != null && newProject.getTechnology().length() > 0 &&
                !Objects.equals(project.getTechnology(), newProject.getTechnology())) {
            project.setTechnology(newProject.getTechnology());
        }

        if(newProject.getAbout() != null && newProject.getAbout().length() > 0 &&
                !Objects.equals(project.getAbout(), newProject.getAbout())) {
            project.setAbout(newProject.getAbout());
        }

        if(newProject.getUrl() != null && newProject.getUrl().length() > 0 &&
                !Objects.equals(project.getUrl(), newProject.getUrl())) {
            project.setUrl(newProject.getUrl());
        }

        if(newProject.getImageUrl() != null && newProject.getImageUrl().length() > 0 &&
                !Objects.equals(project.getUrl(), newProject.getImageUrl())) {
            project.setImageUrl(newProject.getImageUrl());
        }

        if(newProject.getStarred() != null) {
            project.setStarred(newProject.getStarred());
        }


    }

    public void deleteProject(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new IllegalStateException("Project with id " + id + " doesn't exist");
        }
        projectRepository.deleteById(id);
    }

}
