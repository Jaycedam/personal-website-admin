package com.jaycedam.websiteadmin.repo;

import com.jaycedam.websiteadmin.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // All Software Projects (starred)
    @Query("SELECT a " +
            "FROM Project a " +
            "WHERE a.area = 1 AND a.starred = true " +
            "order by a.id DESC")
    List<Project> findAllSwStarredProjects();

    // All Motion Graphics Projects (starred)
    @Query("SELECT a " +
            "FROM Project a " +
            "WHERE a.area = 2 AND a.starred = true " +
            "order by a.id DESC")
    List<Project> findAllMgStarredProjects();

    // All projects
    @Query("SELECT a " +
            "FROM Project a " +
            "order by a.area, a.id DESC")
    List<Project> findAllProjects();
}
