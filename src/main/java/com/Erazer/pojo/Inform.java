package com.Erazer.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel("团队公告实体类")
public class Inform {
    @ApiModelProperty("公告ID")
    private int inform_id;
    @ApiModelProperty("公告内容")
    private String inform_content;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")//指定日期JSON字符串输出格式
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")//指定输入日期格式
    @ApiModelProperty("公告创建时间")
    private Date inform_create_time;
    @ApiModelProperty("公告创建人员名称")
    private String inform_username;
    @ApiModelProperty("公告标题")
    private String inform_title;

    public int getInform_id() {
        return inform_id;
    }

    public void setInform_id(int inform_id) {
        this.inform_id = inform_id;
    }

    public String getInform_content() {
        return inform_content;
    }

    public void setInform_content(String inform_content) {
        this.inform_content = inform_content;
    }

    public Date getInform_create_time() {
        return inform_create_time;
    }

    public void setInform_create_time(Date inform_create_time) {
        this.inform_create_time = inform_create_time;
    }

    public String getInform_username() {
        return inform_username;
    }

    public void setInform_username(String inform_username) {
        this.inform_username = inform_username;
    }

    public String getInform_title() {
        return inform_title;
    }

    public void setInform_title(String inform_title) {
        this.inform_title = inform_title;
    }
}
