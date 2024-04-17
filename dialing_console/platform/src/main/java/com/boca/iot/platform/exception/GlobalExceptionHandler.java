package com.boca.iot.platform.exception;


import com.boca.iot.platform.model.vo.common.Result;
import com.boca.iot.platform.model.vo.common.ResultCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    // 全局异常处理
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.build(null, ResultCodeEnum.SYSTEM_ERROR);
    }

    // 自定义异常处理
    @ExceptionHandler(DialingException.class)
    @ResponseBody
    public Result error(DialingException e) {
        return Result.build(null, e.getResultCodeEnum());
    }

}
