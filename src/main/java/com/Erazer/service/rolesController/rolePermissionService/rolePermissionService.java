package com.Erazer.service.rolesController.rolePermissionService;

import com.Erazer.pojo.Role_Permission;

import java.util.List;

public interface rolePermissionService {
    List<Role_Permission> getAllRolePermissionMsg();

    Role_Permission getRolePermissionById(int id);

    Role_Permission findRolePermission(Role_Permission rp);

    int addRolePermissionMsg(Role_Permission rp);

    int deleteRolePermission(Role_Permission rp);

    int updateRolePermission(int pId, int rId, Role_Permission rp);
}
