package com.boca.iot.platform.model.dto.system;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author lulinwei
 */
@Data
@ApiModel(value = "请求参数实体类")
public class AssginRoleDto {

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "角色id的List集合")
    private List<Long> roleIdList;

}
