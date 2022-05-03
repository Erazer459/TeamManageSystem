package com.Erazer.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("团队日常照片实体类")
public class Live_Photo {
    @ApiModelProperty("图片ID")
    private int live_photo_id;
    @ApiModelProperty("图片路径")
    private String live_photo_loc;
    @ApiModelProperty("事件ID")
    private int live_id;

    public int getLive_photo_id() {
        return live_photo_id;
    }

    public void setLive_photo_id(int live_photo_id) {
        this.live_photo_id = live_photo_id;
    }

    public String getLive_photo_loc() {
        return live_photo_loc;
    }

    public void setLive_photo_loc(String live_photo_loc) {
        this.live_photo_loc = live_photo_loc;
    }

    public int getLive_id() {
        return live_id;
    }

    public void setLive_id(int live_id) {
        this.live_id = live_id;
    }
}
