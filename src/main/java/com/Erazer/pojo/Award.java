package com.Erazer.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@ApiModel("奖项实体类")
public class Award {
    @ApiModelProperty("奖项ID")
    private int award_id;
    @ApiModelProperty("奖项名称")
    private String award_name;
    @ApiModelProperty("获奖时间")
    @JsonFormat(pattern = "yyyy-MM-dd")//指定日期JSON字符串输出格式
    @DateTimeFormat(pattern = "yyyy-MM-dd")//指定输入日期格式
    private Date award_time;
    @JsonIgnore
    private List<Award_Photo> photos;

    public List<Award_Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Award_Photo> photos) {
        this.photos = photos;
    }

    public int getAward_id() {
        return award_id;
    }

    public void setAward_id(int award_id) {
        this.award_id = award_id;
    }

    public String getAward_name() {
        return award_name;
    }

    public void setAward_name(String award_name) {
        this.award_name = award_name;
    }

    public Date getAward_time() {
        return award_time;
    }

    public void setAward_time(Date award_time) {
        this.award_time = award_time;
    }
}
