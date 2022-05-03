package com.Erazer.controller.rolesController.roleController;

import com.Erazer.ApiResult.R;
import com.Erazer.ApiResult.ResultCode;
import com.Erazer.GlobalExceptionResolver.MyException;
import com.Erazer.pojo.Role;
import com.Erazer.service.rolesController.roleService.roleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "角色信息")
@RestController
@RequestMapping("roles/role")
public class roleController {
    @Autowired
    roleService service;

    @GetMapping("/getAllRole")
    @ApiOperation(value = "获取所有角色信息", notes = "获取所有信息", httpMethod = "GET")
    private R getAllRole() throws MyException {
        List<Role> list = service.getAllRole();
        if (list.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        }
        return R.ok().data("items", list);
    }

    @PostMapping("/addRole")
    @ApiOperation(value = "添加角色信息", notes = "添加角色信息", httpMethod = "添加角色信息")
    @ApiImplicitParam(value = "角色ID(无需手动添加)", name = "role_id")
    private R addRole(Role role) throws MyException {
        int flag = service.addRole(role);
        if (flag != 0) {
            return R.ok().data("key", role.getRole_id());
        }
        throw new MyException(ResultCode.POST_ERROR);
    }

    @DeleteMapping("/deleteRole")
    @ApiOperation(value = "删除角色信息", notes = "删除角色信息", httpMethod = "delete")
    @ApiImplicitParam(value = "角色ID", name = "id", required = true)
    private R deleteRole(int id) throws MyException {
        int flag = service.deleteRole(id);
        if (flag != 0) {
            return R.ok().data("OK", "删除成功");
        }
        throw new MyException(ResultCode.DELETE_ERROR);
    }

    @PutMapping("/updateRole")
    @ApiOperation(value = "更新角色信息", notes = "更新角色", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "角色名称", name = "name", required = true),
            @ApiImplicitParam(value = "要进行修改的角色ID", name = "id", required = true)
    })
    private R updateRole(int id, String name) throws MyException {
        int flag = service.updateRole(id, name);
        if (flag != 0) {
            return R.ok().data("OK", "角色更新成功");
        }
        throw new MyException(ResultCode.UPDATE_ERROR);
    }
}
