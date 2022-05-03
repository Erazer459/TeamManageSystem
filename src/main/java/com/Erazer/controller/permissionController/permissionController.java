package com.Erazer.controller.permissionController;

import com.Erazer.ApiResult.R;
import com.Erazer.ApiResult.ResultCode;
import com.Erazer.GlobalExceptionResolver.MyException;
import com.Erazer.pojo.Permission;
import com.Erazer.pojo.Role;
import com.Erazer.service.permissionService.permissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "系统许可信息")
@RestController
@RequestMapping("roles/permission")
public class permissionController {
    @Autowired
    permissionService service;

    @GetMapping("/getAllPermission")
    @ApiOperation(value = "获取所有许可信息", notes = "获取所有信息", httpMethod = "GET")
    private R getAllPermission() throws MyException {
        List<Permission> list = service.getAllPermisson();
        if (list.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        }
        return R.ok().data("items", list);
    }

    @DeleteMapping("/deletePermission")
    @ApiOperation(value = "删除许可信息", notes = "删除信息", httpMethod = "DELETE")
    @ApiImplicitParam(value = "要进行删除的许可的ID", name = "id")
    private R deletePermission(int id) throws MyException {
        int flag = service.deletePermission(id);
        if (flag != 0) {
            return R.ok().data("OK", "删除成功");
        }
        throw new MyException(ResultCode.DELETE_ERROR);
    }

    @PostMapping("/addPermission")
    @ApiOperation(value = "添加许可信息", notes = "添加信息", httpMethod = "POST")
    @ApiImplicitParam(value = "许可ID(无需手动添加)", name = "permission_id")
    private R addPermission(Permission permission) throws MyException {
        int flag = service.addPermission(permission);
        if (flag != 0) {
            return R.ok().data("OK", "添加成功");
        }
        throw new MyException(ResultCode.POST_ERROR);
    }

    @PutMapping("/updatePermission")
    @ApiOperation(value = "更新许可信息", notes = "更新信息", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "要进行更新的许可的ID", name = "id"),
            @ApiImplicitParam(value = "许可ID(无法修改)", name = "permission_id")
    })
    private R updatePermission(int id, Permission permission) throws MyException {
        int flag = service.updatePermission(id, permission);
        if (flag != 0) {
            return R.ok().data("OK", "更新成功");
        }
        throw new MyException(ResultCode.UPDATE_ERROR);
    }

    @GetMapping("/getPermissionRole")
    @ApiOperation(value = "获取许可对应的角色信息", notes = "获取角色信息", httpMethod = "GET")
    @ApiImplicitParam(value = "许可ID", name = "id")
    private R getPermissionRole(int id) throws MyException {
        List<Role> list = service.getPermissionRole(id);
        if (list.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        }
        return R.ok().data("items", list);
    }
}
