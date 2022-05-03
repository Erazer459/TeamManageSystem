package com.Erazer.mapper.permissionMapper;

import com.Erazer.pojo.Permission;
import com.Erazer.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface permissionMapper {
    List<Permission> getAllPermisson();

    int deletePermission(int id);

    int addPermission(Permission permission);

    int updatePermission(@Param("id") int id, @Param("Permission") Permission permission);

    List<Role> getPermissionRole(int id);
}
