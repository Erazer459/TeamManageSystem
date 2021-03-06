package com.Erazer.GlobalExceptionResolver;

import com.Erazer.ApiResult.R;
import com.Erazer.ApiResult.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
/*
  全局异常信息处理类
 */
public class GlobalExceptionResolver {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    /**
     * 处理所有不可知异常
     *
     * @param e 异常
     * @return json结果
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R handleException(Exception e) {
        // 打印异常堆栈信息
        LOG.error(e.getMessage(), e);
        return R.of(ResultCode.UNKNOWN_ERROR);
    }

    /**
     * 处理所有业务异常
     *
     * @param e 业务异常
     * @return json结果
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public R handleOpdRuntimeException(MyException e) {
        // 不打印异常堆栈信息
        LOG.error(e.getMsg());
        return R.of(e.getResultCode());
    }
}
