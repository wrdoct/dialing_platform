package com.boca.iot.platform.model.entity.user;


import com.baomidou.mybatisplus.annotation.TableName;
import com.boca.iot.platform.model.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author lulinwei
 */
@Data
@TableName(value = "user_info")
@ApiModel(value = "UserInfo实体", description = "用户信息实体类")
public class UserInfo extends BaseEntity {

   private static final long serialVersionUID = 1L;

   @ApiModelProperty(value = "用户名")
   private String username;

   @ApiModelProperty(value = "密码")
   private String password;

   @ApiModelProperty(value = "昵称")
   private String nickName;

   @ApiModelProperty(value = "头像")
   private String avatar;

   @ApiModelProperty(value = "性别")
   private Integer sex;

   @ApiModelProperty(value = "电话号码")
   private String phone;

   @ApiModelProperty(value = "备注")
   private String memo;

   @ApiModelProperty(value = "微信open id")
   private String openId;

   @ApiModelProperty(value = "微信开放平台unionID")
   private String unionId;

   @ApiModelProperty(value = "最后一次登录ip")
   private String lastLoginIp;

   @ApiModelProperty(value = "最后一次登录时间")
   private Date lastLoginTime;

   @ApiModelProperty(value = "状态：1为正常，0为禁止")
   private Integer status;

}
