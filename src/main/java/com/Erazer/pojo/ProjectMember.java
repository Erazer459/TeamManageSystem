package com.Erazer.pojo;

import io.swagger.annotations.ApiModelProperty;

public class ProjectMember {
    @ApiModelProperty("成员ID")
    private int member_id;
    @ApiModelProperty("成员姓名")
    private String member_name;
    @ApiModelProperty("项目ID")
    private int project_id;
    @ApiModelProperty("项目名称")
    private String project_name;

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }
}
