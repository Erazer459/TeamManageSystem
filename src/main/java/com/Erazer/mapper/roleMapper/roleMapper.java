package com.Erazer.mapper.roleMapper;

import com.Erazer.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface roleMapper {
    List<Role> getAllRole();

    int addRole(Role role);

    int deleteRole(int id);

    int updateRole(@Param("id") int id, @Param("name") String name);
}
