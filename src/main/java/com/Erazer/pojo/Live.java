package com.Erazer.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@ApiModel("团队日常实体类")
public class Live {
    @ApiModelProperty("事件ID")
    private int live_id;
    @ApiModelProperty("事件描述")
    private String live_content;
    @ApiModelProperty("事件名称")
    private String live_name;
    @ApiModelProperty("事件举行时间")
    @JsonFormat(pattern = "yyyy-MM-dd")//指定日期JSON字符串输出格式
    @DateTimeFormat(pattern = "yyyy-MM-dd")//指定输入日期格式
    private Date live_time;

    public int getLive_id() {
        return live_id;
    }

    public void setLive_id(int live_id) {
        this.live_id = live_id;
    }

    public String getLive_content() {
        return live_content;
    }

    public void setLive_content(String live_content) {
        this.live_content = live_content;
    }

    public String getLive_name() {
        return live_name;
    }

    public void setLive_name(String live_name) {
        this.live_name = live_name;
    }

    public Date getLive_time() {
        return live_time;
    }

    public void setLive_time(Date live_time) {
        this.live_time = live_time;
    }
}
