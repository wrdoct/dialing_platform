package com.boca.iot.platform.mapper;


import com.boca.iot.platform.model.dto.system.SysRoleDto;
import com.boca.iot.platform.model.entity.system.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lulinwei
 */
@Mapper
@Repository
public interface SysRoleMapper {

    // 分页角色列表
    public abstract List<SysRole> findByPage(SysRoleDto sysRoleDto);

    // 添加角色
    void saveSysRole(SysRole sysRole);

    //修改角色
    void updateSysRole(SysRole sysRole);

    //删除角色
    void deleteById(Long roleId);

    List<SysRole> findAllRoles();

}
