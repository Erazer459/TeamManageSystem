package com.Erazer.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("项目实体类")
public class Project {
    @ApiModelProperty("项目ID")
    private int project_id;
    @ApiModelProperty("项目内容描述")
    private String project_content;
    @ApiModelProperty("项目名称")
    private String project_name;
    @ApiModelProperty("项目GIF图片路径")
    private String project_gif;

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_content() {
        return project_content;
    }

    public void setProject_content(String project_content) {
        this.project_content = project_content;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_gif() {
        return project_gif;
    }

    public void setProject_gif(String project_gif) {
        this.project_gif = project_gif;
    }
}
