package com.Erazer.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel("领导视察事件实体类")
public class Lead_Inspection {
    @ApiModelProperty("事件ID")
    private int id;
    @ApiModelProperty("事件描述")
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd")//指定日期JSON字符串输出格式
    @DateTimeFormat(pattern = "yyyy-MM-dd")//指定输入日期格式
    @ApiModelProperty("事件日期")
    private Date date;
    @ApiModelProperty("事件图片路径")
    private String img;
    @ApiModelProperty("事件标题")
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
