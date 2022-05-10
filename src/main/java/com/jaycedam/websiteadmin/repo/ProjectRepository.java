package com.jaycedam.websiteadmin.repo;

import com.jaycedam.websiteadmin.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
