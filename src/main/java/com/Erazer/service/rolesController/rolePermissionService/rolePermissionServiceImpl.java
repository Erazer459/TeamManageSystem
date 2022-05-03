package com.Erazer.service.rolesController.rolePermissionService;

import com.Erazer.mapper.rolePermissionMapper.rolePermissionMapper;
import com.Erazer.pojo.Role_Permission;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class rolePermissionServiceImpl implements rolePermissionService {
    @Resource
    rolePermissionMapper mapper;

    @Override
    public List<Role_Permission> getAllRolePermissionMsg() {
        return mapper.getAllRolePermissionMsg();
    }

    @Override
    public Role_Permission getRolePermissionById(int id) {
        return mapper.getRolePermissionById(id);
    }

    @Override
    public Role_Permission findRolePermission(Role_Permission rp) {
        return mapper.findRolePermission(rp);
    }

    @Override
    public int addRolePermissionMsg(Role_Permission rp) {
        return mapper.addRolePermissionMsg(rp);
    }

    @Override
    public int deleteRolePermission(Role_Permission rp) {
        return mapper.deleteRolePermission(rp);
    }

    @Override
    public int updateRolePermission(int pId, int rId, Role_Permission rp) {

        return mapper.updateRolePermission(pId, rId, rp);
    }
}
