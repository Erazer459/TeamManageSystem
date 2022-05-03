package com.Erazer.controller.rolesController.rolePermissionController;

import com.Erazer.ApiResult.R;
import com.Erazer.ApiResult.ResultCode;
import com.Erazer.GlobalExceptionResolver.MyException;
import com.Erazer.pojo.Role_Permission;
import com.Erazer.service.rolesController.rolePermissionService.rolePermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "角色许可信息")
@RestController
@RequestMapping("roles/rolePermission")
public class rolePermissionController {
    @Autowired
    rolePermissionService service;

    @GetMapping("/getAllRolePermissionMsg")
    @ApiOperation(value = "获取所有角色与许可联系信息", notes = "获取所有信息", httpMethod = "GET")
    private R getAllRolePermissionMsg() throws MyException {
        List<Role_Permission> list = service.getAllRolePermissionMsg();
        if (list.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        }
        return R.ok().data("items", list);
    }

    @GetMapping("/getRolePermissionById")
    @ApiOperation(value = "通过许可ID获取角色信息", notes = "获取许可的角色信息", httpMethod = "GET")
    @ApiImplicitParam(value = "许可ID", name = "id")
    private R getRolePermissionById(int id) throws MyException {
        Role_Permission rp = service.getRolePermissionById(id);
        if (rp != null) {
            return R.ok().data("item", rp);
        }
        throw new MyException(ResultCode.GET_ERROR);
    }

    @PostMapping("/addRolePermissionMsg")
    @ApiOperation(value = "添加角色许可信息", notes = "添加角色许可信息", httpMethod = "POST")
    private R addRolePermissionMsg(Role_Permission rp) throws MyException {
        if (service.findRolePermission(rp) != null) {
            throw new MyException(ResultCode.EXIST_ERROR);
        }
        int flag = service.addRolePermissionMsg(rp);
        if (flag != 0) {
            return R.ok().data("OK", "添加信息成功");
        }
        throw new MyException(ResultCode.POST_ERROR);
    }

    @DeleteMapping("/deleteRolePermission")
    @ApiOperation(value = "删除角色许可联系信息", notes = "删除信息", httpMethod = "DELETE")
    private R deleteRolePermission(Role_Permission rp) throws MyException {
        int flag = service.deleteRolePermission(rp);
        if (flag != 0) {
            return R.ok().data("OK", "删除信息成功");
        }
        throw new MyException(ResultCode.DELETE_ERROR);
    }

    @PutMapping("/updateRolePermission")
    @ApiOperation(value = "更新角色许可联系信息", notes = "更新信息", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "要进行修改的信息的角色ID", name = "rId"),
            @ApiImplicitParam(value = "要进行修改的信息的许可ID", name = "pId")
    })
    private R updateRolePermission(int pId, int rId, Role_Permission rp) throws MyException {
        if (service.findRolePermission(rp) != null) {
            throw new MyException(ResultCode.EXIST_ERROR);
        }
        int flag = service.updateRolePermission(pId, rId, rp);
        if (flag != 0) {
            return R.ok().data("OK", "更新成功");
        }
        throw new MyException(ResultCode.UPDATE_ERROR);
    }
}
