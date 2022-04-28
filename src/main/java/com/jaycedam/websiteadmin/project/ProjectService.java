package com.jaycedam.websiteadmin.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getProjects() {
        return projectRepository.findAll(Sort.by("id"));
    }

    public void createProject(Project project) {
        projectRepository.save(project);
    }

    @Transactional
    public void updateProject(Long id,
                              String name,
                              String about,
                              String url) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Project with id " + id + "doesn't exist."
        ));

        if(name != null && name.length() > 0 &&
        !Objects.equals(project.getName(), name)) {
            project.setName(name);
        }

        if(about != null && about.length() > 0 &&
                !Objects.equals(project.getAbout(), about)) {
            project.setAbout(about);
        }

        if(url != null && url.length() > 0 &&
                !Objects.equals(project.getUrl(), url)) {
            project.setUrl(url);
        }

    }

    public void deleteProject(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new IllegalStateException("Project with id " + id + " does not exist");
        }

        projectRepository.deleteById(id);
    }

}
