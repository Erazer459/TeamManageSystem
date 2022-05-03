package com.Erazer.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("团队成员获得奖项")
public class Member_Award {
    @ApiModelProperty("成员ID")
    private int member_id;
    @ApiModelProperty("奖项ID")
    private int award_id;

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getAward_id() {
        return award_id;
    }

    public void setAward_id(int award_id) {
        this.award_id = award_id;
    }
}
