package com.Erazer.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("教师实体类")
public class Teacher {
    @ApiModelProperty("教师id")
    private int teacher_id;//教师id
    @ApiModelProperty("教室姓名")
    private String teacher_name;
    @ApiModelProperty("教师邮箱")
    private String teacher_email;
    @ApiModelProperty("教师出生地")
    private String teacher_born;
    @ApiModelProperty("教师职位")
    private String teacher_job;
    @ApiModelProperty("教师毕业大学")
    private String teacher_graduation;
    @ApiModelProperty("教师职称")
    private String teacher_position;
    @ApiModelProperty("教师研究方向")
    private String teacher_research;
    @ApiModelProperty("教师科研项目")
    private String teacher_scientific_research;
    @ApiModelProperty("教师获得奖项")
    private String teacher_award_introduction;
    @ApiModelProperty("教师照片")
    private String teacher_img;
    @ApiModelProperty("角色ID")
    private int role_id;
    @ApiModelProperty("教师密码")
    private String teacher_password;

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_email() {
        return teacher_email;
    }

    public void setTeacher_email(String teacher_email) {
        this.teacher_email = teacher_email;
    }

    public String getTeacher_born() {
        return teacher_born;
    }

    public void setTeacher_born(String teacher_born) {
        this.teacher_born = teacher_born;
    }

    public String getTeacher_job() {
        return teacher_job;
    }

    public void setTeacher_job(String teacher_job) {
        this.teacher_job = teacher_job;
    }

    public String getTeacher_graduation() {
        return teacher_graduation;
    }

    public void setTeacher_graduation(String teacher_graduation) {
        this.teacher_graduation = teacher_graduation;
    }

    public String getTeacher_position() {
        return teacher_position;
    }

    public void setTeacher_position(String teacher_position) {
        this.teacher_position = teacher_position;
    }

    public String getTeacher_research() {
        return teacher_research;
    }

    public void setTeacher_research(String teacher_research) {
        this.teacher_research = teacher_research;
    }

    public String getTeacher_scientific_research() {
        return teacher_scientific_research;
    }

    public void setTeacher_scientific_research(String teacher_scientific_research) {
        this.teacher_scientific_research = teacher_scientific_research;
    }

    public String getTeacher_award_introduction() {
        return teacher_award_introduction;
    }

    public void setTeacher_award_introduction(String teacher_award_introduction) {
        this.teacher_award_introduction = teacher_award_introduction;
    }

    public String getTeacher_img() {
        return teacher_img;
    }

    public void setTeacher_img(String teacher_img) {
        this.teacher_img = teacher_img;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getTeacher_password() {
        return teacher_password;
    }

    public void setTeacher_password(String teacher_password) {
        this.teacher_password = teacher_password;
    }
}
