package com.Erazer.GlobalExceptionResolver;

import com.Erazer.ApiResult.ResultCode;

/**
 * 自定义业务异常
 */
public class MyException extends Exception {
    /**
     * 结果码
     */
    private int code;

    /**
     * 结果码描述
     */
    private String msg;

    /**
     * 结果码枚举
     */
    private ResultCode resultCode;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public MyException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.resultCode = resultCode;
    }
}
