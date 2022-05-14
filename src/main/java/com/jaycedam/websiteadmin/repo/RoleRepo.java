package com.jaycedam.websiteadmin.repo;

import com.jaycedam.websiteadmin.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepo extends JpaRepository<Role, Long> {
    @Query("SELECT a FROM Role a WHERE a.name=:name")
    Role findByName(@Param("name") String name);

}
