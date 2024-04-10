package com.boca.iot.manager.model.entity.system;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boca.iot.manager.model.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lulinwei
 */
@Data
@TableName(value = "sys_role")
@ApiModel(value = "SysRole实体", description = "角色实体类")
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色编码")
    private String roleCode;

    @ApiModelProperty(value = "描述")
    private String description;

}
