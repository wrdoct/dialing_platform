package com.boca.iot.platform.service;


import com.boca.iot.platform.model.dto.system.SysRoleDto;
import com.boca.iot.platform.model.entity.system.SysRole;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @author lulinwei
 */
public interface SysRoleService {

    // 分页角色列表
    PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, Integer pageNum, Integer pageSize);

    // 添加角色
    void saveSysRole(SysRole sysRole);

    //修改角色
    void updateSysRole(SysRole sysRole);

    //删除角色
    void deleteById(Long roleId);

    Map<String, Object> findAllRoles(Long userId);

}
