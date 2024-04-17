package com.boca.iot.platform.mapper;


import com.boca.iot.platform.model.dto.system.AssginMenuDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lulinwei
 */
@Mapper
public interface SysRoleMenuMapper {

    List<Long> findSysRoleMenuByRoleId(Long roleId);

    void deleteByRoleId(Long roleId);
    void doAssign(AssginMenuDto assginMenuDto);

    void updateSysRoleMenuIsHalf(Long menuId);

}
