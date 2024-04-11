package com.boca.iot.manager.service;


import com.boca.iot.manager.model.dto.system.AssginRoleDto;
import com.boca.iot.manager.model.dto.system.LoginDto;
import com.boca.iot.manager.model.dto.system.SysUserDto;
import com.boca.iot.manager.model.entity.system.SysUser;
import com.boca.iot.manager.model.vo.system.LoginVo;
import com.github.pagehelper.PageInfo;

/**
 * @author lulinwei
 */
public interface SysUserService {

    /**
     * 根据用户名查询用户数据
     * @return
     */
    // 用户登录
    LoginVo login(LoginDto loginDto);

    // 获取当前登录用户信息
    SysUser getUserInfo(String token);

    // 用户退出
    void logout(String token);

    PageInfo<SysUser> findByPage(SysUserDto sysUserDto, Integer pageNum, Integer pageSize);

    void saveSysUser(SysUser sysUser);

    void updateSysUser(SysUser sysUser);

    void deleteById(Long userId);

    void doAssign(AssginRoleDto assginRoleDto);

}
