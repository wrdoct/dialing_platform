package com.boca.iot.manager.model.entity.system;


import com.baomidou.mybatisplus.annotation.TableName;
import com.boca.iot.manager.model.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author lulinwei
 */
@Data
@TableName(value = "sys_menu")
@ApiModel(value = "SysMenu实体", description = "系统菜单实体类")
public class SysMenu extends BaseEntity {

	@ApiModelProperty(value = "父节点id")
	private Long parentId;

	@ApiModelProperty(value = "节点标题")
	private String title;

	@ApiModelProperty(value = "组件名称")
	private String component;

	@ApiModelProperty(value = "排序值")
	private Integer sortValue;

	@ApiModelProperty(value = "状态(0:禁止,1:正常)")
	private Integer status;

	// 下级列表
	@ApiModelProperty(value = "子节点")
	private List<SysMenu> children;

}
