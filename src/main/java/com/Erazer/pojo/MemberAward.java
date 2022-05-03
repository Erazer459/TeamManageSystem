package com.Erazer.pojo;

import io.swagger.annotations.ApiModelProperty;
/**
 *DTO
 */
public class MemberAward {
    @ApiModelProperty("成员ID")
    private int member_id;
    @ApiModelProperty("奖项ID")
    private int award_id;
    @ApiModelProperty("成员姓名")
    private String member_name;
    @ApiModelProperty("奖项名称")
    private String award_name;

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

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getAward_name() {
        return award_name;
    }

    public void setAward_name(String award_name) {
        this.award_name = award_name;
    }


}
