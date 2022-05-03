package com.Erazer.service.rolesController.roleService;

import com.Erazer.pojo.Role;

import java.util.List;

public interface roleService {
    List<Role> getAllRole();

    int addRole(Role role);

    int deleteRole(int id);

    int updateRole(int id, String name);
}
