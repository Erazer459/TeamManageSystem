package com.Erazer.ApiResult;

public enum ResultCode {
    //public static Integer SUCCESS = 20000; 成功
    //public static Integer ERROR = 20001; 失败
    SUCCESS("成功", 20000, true),
    GET_ERROR("获取信息失败或不存在信息", 20001, false),
    UPDATE_ERROR("更新信息失败", 20003, false),
    DELETE_ERROR("删除信息失败", 20005, false),
    POST_ERROR("添加信息失败", 20004, false),
    EXIST_ERROR("信息已存在", 20006, false),
    UNKNOWN_ERROR("未知错误", 20002, false);
    private int code;
    private String msg;
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    ResultCode(String msg, int code, boolean success) {
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
