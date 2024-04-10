package com.boca.iot.manager.model.vo.system;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 验证码响应结果实体类
 *
 * @author lulinwei
 */
@Data
public class ValidateCodeVo {

    @ApiModelProperty(value = "验证码key")
    private String codeKey ;        // 验证码的key

    @ApiModelProperty(value = "验证码value")
    private String codeValue ;      // 图片验证码对应的字符串数据

}
