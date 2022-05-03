package com.Erazer.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel("团队成员实体类")
public class Member {
    @ApiModelProperty("成员id")
    private int member_id;//成员id
    @ApiModelProperty("毕业去向")
    private String mem_after_graduated_destination;//毕业去向
    @ApiModelProperty("成员生日(不能模糊查询)")
    @JsonFormat(pattern = "yyyy-MM-dd")//指定日期JSON字符串输出格式
    @DateTimeFormat(pattern = "yyyy-MM-dd")//指定输入日期格式
    private Date member_birthday;//成员生日
    @ApiModelProperty("成员职位")
    private String member_identity;//成员职位
    @ApiModelProperty("成员班级")
    private String member_class;//成员班级
    @ApiModelProperty("成员照片")
    private String member_icon;//成员照片
    @ApiModelProperty("成员自我介绍")
    private String member_introduction;//成员自我介绍
    @ApiModelProperty("成员专业")
    private String member_major;//成员专业
    @ApiModelProperty("成员姓名")
    private String member_name;//成员姓名
    @ApiModelProperty("成员学号")
    private String member_stu_id;//成员学号
    @ApiModelProperty("成员方向")
    private String member_technology;//成员方向
    @ApiModelProperty("成员密码")
    private String member_password;//成员密码
    @ApiModelProperty("成员手机号")
    private String member_telephone;//成员手机号
    @ApiModelProperty("角色id")
    private int role_id;//角色id


    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getMem_after_graduated_destination() {
        return mem_after_graduated_destination;
    }

    public void setMem_after_graduated_destination(String mem_after_graduated_destination) {
        this.mem_after_graduated_destination = mem_after_graduated_destination;
    }

    public Date getMember_birthday() {
        return member_birthday;
    }

    public void setMember_birthday(Date member_birthday) {
        this.member_birthday = member_birthday;
    }

    public String getMember_identity() {
        return member_identity;
    }

    public void setMember_identity(String member_identity) {
        this.member_identity = member_identity;
    }

    public String getMember_class() {
        return member_class;
    }

    public void setMember_class(String member_class) {
        this.member_class = member_class;
    }

    public String getMember_icon() {
        return member_icon;
    }

    public void setMember_icon(String member_icon) {
        this.member_icon = member_icon;
    }

    public String getMember_introduction() {
        return member_introduction;
    }

    public void setMember_introduction(String member_introduction) {
        this.member_introduction = member_introduction;
    }

    public String getMember_major() {
        return member_major;
    }

    public void setMember_major(String member_major) {
        this.member_major = member_major;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_stu_id() {
        return member_stu_id;
    }

    public void setMember_stu_id(String member_stu_id) {
        this.member_stu_id = member_stu_id;
    }

    public String getMember_technology() {
        return member_technology;
    }

    public void setMember_technology(String member_technology) {
        this.member_technology = member_technology;
    }

    public String getMember_password() {
        return member_password;
    }

    public void setMember_password(String member_password) {
        this.member_password = member_password;
    }

    public String getMember_telephone() {
        return member_telephone;
    }

    public void setMember_telephone(String member_telephone) {
        this.member_telephone = member_telephone;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
