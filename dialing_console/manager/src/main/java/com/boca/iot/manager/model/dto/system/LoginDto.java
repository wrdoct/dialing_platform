package com.boca.iot.manager.model.dto.system;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lulinwei
 */
@Data
@ApiModel(value = "用户登录请求参数")
public class LoginDto {

    @ApiModelProperty(value = "用户名")
    private String userName ;

    @ApiModelProperty(value = "密码")
    private String password ;

    @ApiModelProperty(value = "提交验证码")
    private String captcha ;

    @ApiModelProperty(value = "验证码key")
    private String codeKey ;

}
