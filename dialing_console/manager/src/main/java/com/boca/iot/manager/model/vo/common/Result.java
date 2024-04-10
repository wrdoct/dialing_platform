package com.boca.iot.manager.model.vo.common;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 响应结果实体类
 *
 * @author lulinwei
 * @param <T>
 */
@Data
public class Result<T> {

    //返回码
    @ApiModelProperty(value = "业务状态码")
    private Integer code;

    //返回消息
    @ApiModelProperty(value = "响应消息")
    private String message;

    //返回数据
    @ApiModelProperty(value = "业务数据")
    private T data;

    // 私有化构造
    private Result() {}

    // 返回数据
    public static <T> Result<T> build(T body, Integer code, String message) {
        Result<T> result = new Result<>();
        result.setData(body);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    // 通过枚举构造Result对象
    public static <T> Result build(T body , ResultCodeEnum resultCodeEnum) {
        return build(body , resultCodeEnum.getCode() , resultCodeEnum.getMessage()) ;
    }

}
