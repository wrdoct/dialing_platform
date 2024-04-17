package com.boca.iot.platform.service;


import com.boca.iot.platform.model.dto.system.AssginMenuDto;

import java.util.Map;

/**
 * @author lulinwei
 */
public interface SysRoleMenuService {

    Map<String, Object> findSysRoleMenuByRoleId(Long roleId);

    void doAssign(AssginMenuDto assginMenuDto);

}
