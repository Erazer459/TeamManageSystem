package com.Erazer.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("项目图片")
public class Project_Photo {
    @ApiModelProperty("项目图片ID")
    private int project_photo_id;
    @ApiModelProperty("项目图片路径")
    private String project_photo_loc;
    @ApiModelProperty("项目ID")
    private int project_id;

    public int getProject_photo_id() {
        return project_photo_id;
    }

    public void setProject_photo_id(int project_photo_id) {
        this.project_photo_id = project_photo_id;
    }

    public String getProject_photo_loc() {
        return project_photo_loc;
    }

    public void setProject_photo_loc(String project_photo_loc) {
        this.project_photo_loc = project_photo_loc;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
}
