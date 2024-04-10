package com.boca.iot.manager.model.dto.system;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lulinwei
 */
@Data
@ApiModel(value = "请求参数实体类")
public class SysUserDto {

    @ApiModelProperty(value = "搜索关键字")
    private String keyword ;

    @ApiModelProperty(value = "开始时间")
    private String createTimeBegin ;

    @ApiModelProperty(value = "结束时间")
    private String createTimeEnd;

}
