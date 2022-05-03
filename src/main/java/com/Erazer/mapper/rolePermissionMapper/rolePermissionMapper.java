package com.Erazer.mapper.rolePermissionMapper;

import com.Erazer.pojo.Role_Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface rolePermissionMapper {

    List<Role_Permission> getAllRolePermissionMsg();

    Role_Permission getRolePermissionById(int id);

    Role_Permission findRolePermission(Role_Permission rp);

    int addRolePermissionMsg(Role_Permission rp);

    int deleteRolePermission(Role_Permission rp);

    int updateRolePermission(@Param("pId") int pId, @Param("rId") int rId, @Param("Role_Permission") Role_Permission rp);
}
