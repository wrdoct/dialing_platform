package com.boca.iot.platform.mapper;


import com.boca.iot.platform.model.entity.system.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lulinwei
 */
@Mapper
public interface SysMenuMapper {

    List<SysMenu> selectAll();

    void insert(SysMenu sysMenu);

    void updateById(SysMenu sysMenu);

    int countByParentId(Long id);
    void deleteById(Long id);

    List<SysMenu> selectListByUserId(Long userId);

    List<SysMenu> selectListByUserIdSort(Long userId);

    SysMenu selectById(Long id) ;

}
