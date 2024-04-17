package com.boca.iot.platform.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lulinwei
 */
@Mapper
@Repository
public interface SysRoleUserMapper {

    void doAssign(@Param("userId") Long userId,
                  @Param("roleId") Long roleId);		// 添加关联关系
    void deleteByUserId(Long userId);				// 根据用户的id删除数据
    List<Long> findSysUserRoleByUserId(Long userId);

}
