package com.Erazer.ApiResult;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

import static com.Erazer.ApiResult.ResultCode.SUCCESS;

//统一返回结果的类
@Data
public class R {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    public R(ResultCode resultCode) {
        this.success = resultCode.isSuccess();
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
    }

    public static R of(ResultCode resultCode) {
        return new R(resultCode);
    }

    //把构造方法私有
    private R() {
    }

    //成功静态方法
    public static R ok() {
        R r = new R();
        r.setSuccess(SUCCESS.isSuccess());
        r.setCode(SUCCESS.getCode());
        r.setMessage(SUCCESS.getMsg());
        return r;
    }

    /**
     * public static R error() {
     * R r = new R();
     * r.setSuccess(ERROR.isSuccess());
     * r.setCode(ERROR.getCode());
     * r.setMessage(ERROR.getMsg());
     * return r;
     * }
     */

    public R success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}

