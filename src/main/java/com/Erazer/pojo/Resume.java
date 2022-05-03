package com.Erazer.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("简历实体类")
public class Resume {
    @ApiModelProperty("简历ID")
    private int resume_id;
    @ApiModelProperty("方向名称")
    private String resume_direct;
    @ApiModelProperty("自我介绍")
    private String resume_evaluation;
    @ApiModelProperty("项目经验")
    private String resume_experience;
    @ApiModelProperty("进入团队的期望")
    private String resume_expect;
    @ApiModelProperty("班级和专业")
    private String resume_major;
    @ApiModelProperty("学生姓名")
    private String resume_name;
    @ApiModelProperty("其他")
    private String resume_other;
    @ApiModelProperty("方向技能")
    private String resume_skills;
    @ApiModelProperty("学号")
    private String resume_student_id;
    @ApiModelProperty("手机号")
    private String resume_telephone;

    public int getResume_id() {
        return resume_id;
    }

    public void setResume_id(int resume_id) {
        this.resume_id = resume_id;
    }

    public String getResume_direct() {
        return resume_direct;
    }

    public void setResume_direct(String resume_direct) {
        this.resume_direct = resume_direct;
    }

    public String getResume_evaluation() {
        return resume_evaluation;
    }

    public void setResume_evaluation(String resume_evaluation) {
        this.resume_evaluation = resume_evaluation;
    }

    public String getResume_experience() {
        return resume_experience;
    }

    public void setResume_experience(String resume_experience) {
        this.resume_experience = resume_experience;
    }

    public String getResume_expect() {
        return resume_expect;
    }

    public void setResume_expect(String resume_expect) {
        this.resume_expect = resume_expect;
    }

    public String getResume_major() {
        return resume_major;
    }

    public void setResume_major(String resume_major) {
        this.resume_major = resume_major;
    }

    public String getResume_name() {
        return resume_name;
    }

    public void setResume_name(String resume_name) {
        this.resume_name = resume_name;
    }

    public String getResume_other() {
        return resume_other;
    }

    public void setResume_other(String resume_other) {
        this.resume_other = resume_other;
    }

    public String getResume_skills() {
        return resume_skills;
    }

    public void setResume_skills(String resume_skills) {
        this.resume_skills = resume_skills;
    }

    public String getResume_student_id() {
        return resume_student_id;
    }

    public void setResume_student_id(String resume_student_id) {
        this.resume_student_id = resume_student_id;
    }

    public String getResume_telephone() {
        return resume_telephone;
    }

    public void setResume_telephone(String resume_telephone) {
        this.resume_telephone = resume_telephone;
    }
}
