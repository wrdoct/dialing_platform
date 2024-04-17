package com.boca.iot.platform.model.vo.system;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 系统菜单响应结果实体类
 *
 * @author lulinwei
 */
@Data
public class SysMenuVo {

    @ApiModelProperty(value = "系统菜单标题")
    private String title;

    @ApiModelProperty(value = "系统菜单名称")
    private String name;

    @ApiModelProperty(value = "系统菜单子菜单列表")
    private List<SysMenuVo> children;

}
