package com.boca.iot.platform.model.dto.system;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author lulinwei
 */
@Data
@ApiModel(value = "请求参数实体类")
public class AssginMenuDto {

    @ApiModelProperty(value = "角色id")
    private Long roleId;			// 角色id

    @ApiModelProperty(value = "选中的菜单id的集合")
    private List<Map<String , Number>> menuIdList;	// 选中的菜单id的集合; Map的键表示菜单的id，值表示是否为半开; 0否，1是

}
