package com.Erazer.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("通行实体类")
public class Permission {
    @ApiModelProperty("通行ID")
    private int permission_id;
    @ApiModelProperty("通行名称")
    private String permission_name;
    @ApiModelProperty("通行类型")
    private String permission_permission;

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }

    public String getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name;
    }

    public String getPermission_permission() {
        return permission_permission;
    }

    public void setPermission_permission(String permission_permission) {
        this.permission_permission = permission_permission;
    }
}
