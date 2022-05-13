package com.jaycedam.websiteadmin.repo;

import com.jaycedam.websiteadmin.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("SELECT a FROM Project a WHERE a.starred = true order by a.area, a.id")
    List<Project> findAllStarredProjects();

}
