package com.boca.iot.manager.model.dto.system;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lulinwei
 */
@Data
@ApiModel(value = "请求参数实体类")
public class SysRoleDto {

    @ApiModelProperty(value = "角色名称")
    private String roleName ;

}
