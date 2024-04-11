package com.boca.iot.manager.service;


import com.boca.iot.manager.model.entity.system.SysMenu;
import com.boca.iot.manager.model.vo.system.SysMenuVo;

import java.util.List;

/**
 * @author lulinwei
 */
public interface SysMenuService {

    List<SysMenu> findNodes();

    void save(SysMenu sysMenu);

    void updateById(SysMenu sysMenu);

    void removeById(Long id);

    List<SysMenuVo> findUserMenuList();

}
