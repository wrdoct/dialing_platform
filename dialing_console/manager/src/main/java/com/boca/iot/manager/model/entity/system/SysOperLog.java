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
@TableName(value = "sys_oper_log")
@ApiModel(value = "SysOperLog实体", description = "系统操作日志")
public class SysOperLog extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "模块标题")
	private String title;

	@ApiModelProperty(value = "方法名称")
	private String method;

	@ApiModelProperty(value = "请求方式")
	private String requestMethod;

	private String businessType ;			// 业务类型 (0默认，1新增，2删除，3修改，4查询)

	@ApiModelProperty(value = "操作类别（0其它 1后台用户）")
	private String operatorType;

	@ApiModelProperty(value = "操作人员")
	private String operName;

	@ApiModelProperty(value = "请求URL")
	private String operUrl;

	@ApiModelProperty(value = "主机地址")
	private String operIp;

	@ApiModelProperty(value = "请求参数")
	private String operParam;

	@ApiModelProperty(value = "返回参数")
	private String jsonResult;

	@ApiModelProperty(value = "操作状态（0正常 1异常）")
	private Integer status;

	@ApiModelProperty(value = "错误消息")
	private String errorMsg;

}
