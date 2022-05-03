package com.Erazer.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("获奖图片实体类")
public class Award_Photo {
    @ApiModelProperty("获奖图片ID")
    private int award_photo_id;
    @ApiModelProperty("获奖图片路径")
    private String award_photo_loc;
    @ApiModelProperty("奖项ID")
    private int award_id;

    public int getAward_photo_id() {
        return award_photo_id;
    }

    public void setAward_photo_id(int award_photo_id) {
        this.award_photo_id = award_photo_id;
    }

    public String getAward_photo_loc() {
        return award_photo_loc;
    }

    public void setAward_photo_loc(String award_photo_loc) {
        this.award_photo_loc = award_photo_loc;
    }

    public int getAward_id() {
        return award_id;
    }

    public void setAward_id(int award_id) {
        this.award_id = award_id;
    }
}
