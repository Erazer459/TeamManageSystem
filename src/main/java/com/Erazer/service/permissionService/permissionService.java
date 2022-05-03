package com.Erazer.service.permissionService;

import com.Erazer.pojo.Permission;
import com.Erazer.pojo.Role;

import java.util.List;

public interface permissionService {
    List<Permission> getAllPermisson();

    int deletePermission(int id);

    int addPermission(Permission permission);

    int updatePermission(int id, Permission permission);

    List<Role> getPermissionRole(int id);
}
