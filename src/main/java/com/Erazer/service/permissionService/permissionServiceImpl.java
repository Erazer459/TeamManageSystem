package com.Erazer.service.permissionService;

import com.Erazer.mapper.permissionMapper.permissionMapper;
import com.Erazer.pojo.Permission;
import com.Erazer.pojo.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class permissionServiceImpl implements permissionService {
    @Resource
    permissionMapper mapper;

    @Override
    public List<Permission> getAllPermisson() {
        return mapper.getAllPermisson();
    }

    @Override
    public int deletePermission(int id) {
        return mapper.deletePermission(id);
    }

    @Override
    public int addPermission(Permission permission) {
        return mapper.addPermission(permission);
    }

    @Override
    public int updatePermission(int id, Permission permission) {
        return mapper.updatePermission(id, permission);
    }

    @Override
    public List<Role> getPermissionRole(int id) {
        return mapper.getPermissionRole(id);
    }
}
