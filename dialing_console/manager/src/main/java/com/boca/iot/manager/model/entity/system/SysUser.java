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
@TableName(value = "sys_user")
@ApiModel(value = "SysUser实体", description = "系统用户实体类")
public class SysUser extends BaseEntity {

	@ApiModelProperty(value = "用户名")
	private String userName;

	@ApiModelProperty(value = "密码")
	private String password;

	@ApiModelProperty(value = "昵称")
	private String name;

	@ApiModelProperty(value = "手机号码")
	private String phone;

	@ApiModelProperty(value = "图像")
	private String avatar;

	@ApiModelProperty(value = "描述")
	private String description;

	@ApiModelProperty(value = "状态（1：正常 0：停用）")
	private Integer status;

}
