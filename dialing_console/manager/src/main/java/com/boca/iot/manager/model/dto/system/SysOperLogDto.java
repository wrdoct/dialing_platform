package com.boca.iot.manager.model.dto.system;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lulinwei
 */
@Data
@ApiModel(value = "请求参数实体类")
public class SysOperLogDto {

    @ApiModelProperty(value = "模块名称")
    private String title;

    @ApiModelProperty(value = "操作用户名")
    private String operName;

    @ApiModelProperty(value = "开始时间")
    private String createTimeBegin;

    @ApiModelProperty(value = "结束时间")
    private String createTimeEnd;

}
