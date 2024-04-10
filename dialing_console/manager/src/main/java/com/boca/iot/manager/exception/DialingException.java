package com.boca.iot.manager.exception;


import com.boca.iot.manager.model.vo.common.ResultCodeEnum;
import lombok.Data;

/**
 * @author lulinwei
 */
@Data
public class DialingException extends RuntimeException{

    private Integer code ;          // 错误状态码
    private String message ;        // 错误消息
    private ResultCodeEnum resultCodeEnum ;     // 封装错误状态码和错误消息

    public DialingException(ResultCodeEnum resultCodeEnum) {
        this.resultCodeEnum = resultCodeEnum;
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }

    public DialingException(Integer code , String message) {
        this.code = code ;
        this.message = message ;
    }

}
