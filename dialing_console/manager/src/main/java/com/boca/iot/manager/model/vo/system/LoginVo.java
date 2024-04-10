package com.boca.iot.manager.model.vo.system;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 登录成功响应结果实体类
 *
 * @author lulinwei
 */
@Data
public class LoginVo {

    @ApiModelProperty(value = "令牌")
    private String token ;

    @ApiModelProperty(value = "刷新令牌,可以为空")
    private String refresh_token ;

}
