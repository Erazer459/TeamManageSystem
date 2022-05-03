package com.Erazer.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel("团队历史实体类")
public class History {
    @ApiModelProperty("历史ID")
    private int history_id;
    @ApiModelProperty("历史编辑时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")//指定日期JSON字符串返回格式
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")//指定输入日期格式
    private Date history_edit_time;
    @ApiModelProperty("历史描述")
    private String history_info;
    @ApiModelProperty("历史视频路径")
    private String history_video;

    public int getHistory_id() {
        return history_id;
    }

    public void setHistory_id(int history_id) {
        this.history_id = history_id;
    }

    public Date getHistory_edit_time() {
        return history_edit_time;
    }

    public void setHistory_edit_time(Date history_edit_time) {
        this.history_edit_time = history_edit_time;
    }

    public String getHistory_info() {
        return history_info;
    }

    public void setHistory_info(String history_info) {
        this.history_info = history_info;
    }

    public String getHistory_video() {
        return history_video;
    }

    public void setHistory_video(String history_video) {
        this.history_video = history_video;
    }
}
