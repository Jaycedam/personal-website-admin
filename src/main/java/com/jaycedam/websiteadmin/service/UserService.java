package com.jaycedam.websiteadmin.service;

import com.jaycedam.websiteadmin.domain.AppUser;
import com.jaycedam.websiteadmin.domain.Role;

import java.util.List;

public interface UserService {
    void saveUser(AppUser appUser);
    void saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
