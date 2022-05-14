package com.jaycedam.websiteadmin.repo;

import com.jaycedam.websiteadmin.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<AppUser, Long> {

    @Query("SELECT a FROM AppUser a WHERE a.username=:username")
    AppUser findByUsername(@Param("username") String username);

}
