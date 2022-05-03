package com.Erazer.service.rolesController.roleService;

import com.Erazer.mapper.roleMapper.roleMapper;
import com.Erazer.pojo.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class roleServiceImpl implements roleService {
    @Resource
    roleMapper mapper;

    @Override
    public List<Role> getAllRole() {
        return mapper.getAllRole();
    }

    @Override
    public int addRole(Role role) {
        return mapper.addRole(role);
    }

    @Override
    public int deleteRole(int id) {
        return mapper.deleteRole(id);
    }

    @Override
    public int updateRole(int id, String name) {
        return mapper.updateRole(id, name);
    }
}
