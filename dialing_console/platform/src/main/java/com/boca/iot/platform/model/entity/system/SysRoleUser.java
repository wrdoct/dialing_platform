package com.boca.iot.platform.model.entity.system;


import com.baomidou.mybatisplus.annotation.TableName;
import com.boca.iot.platform.model.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author lulinwei
 */
@Data
@TableName(value = "sys_role_user")
@ApiModel(value = "SysRoleUser实体", description = "角色用户实体类")
public class SysRoleUser extends BaseEntity {

    private Long roleId;       // 角色id
    private Long userId;       // 用户id

}
