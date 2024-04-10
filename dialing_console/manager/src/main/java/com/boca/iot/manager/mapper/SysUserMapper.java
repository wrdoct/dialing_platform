package com.boca.iot.manager.mapper;


import com.boca.iot.manager.model.dto.system.SysUserDto;
import com.boca.iot.manager.model.entity.system.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lulinwei
 */
@Mapper
@Repository
public interface SysUserMapper {

    /**
     * 根据用户名查询用户数据
     * @param userName
     * @return
     */
    SysUser selectByUserName(String userName) ;

    List<SysUser> findByPage(SysUserDto sysUserDto);

    public abstract SysUser findByUserName(String name);

    public abstract void saveSysUser(SysUser sysUser);

    void updateSysUser(SysUser sysUser);

    void deleteById(Long userId);

}
