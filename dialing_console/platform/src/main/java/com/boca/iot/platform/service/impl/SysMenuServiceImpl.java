package com.boca.iot.platform.service.impl;


import com.alibaba.excel.util.CollectionUtils;
import com.boca.iot.platform.exception.DialingException;
import com.boca.iot.platform.mapper.SysMenuMapper;
import com.boca.iot.platform.mapper.SysRoleMenuMapper;
import com.boca.iot.platform.model.entity.system.SysMenu;
import com.boca.iot.platform.model.entity.system.SysUser;
import com.boca.iot.platform.model.vo.common.ResultCodeEnum;
import com.boca.iot.platform.model.vo.system.SysMenuVo;
import com.boca.iot.platform.service.SysMenuService;
import com.boca.iot.platform.utils.AuthContextUtil;
import com.boca.iot.platform.utils.MenuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lulinwei
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper ;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public List<SysMenu> findNodes() {
        List<SysMenu> sysMenuList = sysMenuMapper.selectAll() ;
        if (CollectionUtils.isEmpty(sysMenuList)) return null;
        List<SysMenu> treeList = MenuUtil.buildTree(sysMenuList); //构建树形数据
        return treeList;
    }

    @Override
    public void save(SysMenu sysMenu) {
        // 添加新的节点
        sysMenuMapper.insert(sysMenu) ;
        // 新添加一个菜单，那么此时就需要将该菜单所对应的父级菜单设置为半开
        updateSysRoleMenuIsHalf(sysMenu) ;
    }

    private void updateSysRoleMenuIsHalf(SysMenu sysMenu) {
        // 查询是否存在父节点
        SysMenu parentMenu = sysMenuMapper.selectById(sysMenu.getParentId());
        if(parentMenu != null) {
            // 将该id的菜单设置为半开
            sysRoleMenuMapper.updateSysRoleMenuIsHalf(parentMenu.getId()) ;
            // 递归调用
            updateSysRoleMenuIsHalf(parentMenu) ;
        }
    }

    @Override
    public void updateById(SysMenu sysMenu) {
        sysMenuMapper.updateById(sysMenu) ;
    }

    @Override
    public void removeById(Long id) {
        // 先查询是否存在子菜单，如果存在不允许进行删除
        int count = sysMenuMapper.countByParentId(id);
        if (count > 0) {
            throw new DialingException(ResultCodeEnum.NODE_ERROR);
        }
        // 不存在子菜单直接删除
        sysMenuMapper.deleteById(id);
    }

    @Override
    public List<SysMenuVo> findUserMenuList() {

        // 获取当前登录用户的id
        SysUser sysUser = AuthContextUtil.get();
        Long userId = sysUser.getId();

//        List<SysMenu> sysMenuList = sysMenuMapper.selectListByUserId(userId) ;
        List<SysMenu> sysMenuList = sysMenuMapper.selectListByUserIdSort(userId) ;

        //构建树形数据
        List<SysMenu> sysMenuTreeList = MenuUtil.buildTree(sysMenuList);
        return this.buildMenus(sysMenuTreeList);
    }

    /**
     * 将List<SysMenu>对象转换成List<SysMenuVo>对象
     */
    private List<SysMenuVo> buildMenus(List<SysMenu> menus) {

        List<SysMenuVo> sysMenuVoList = new LinkedList<SysMenuVo>();
        for (SysMenu sysMenu : menus) {
            SysMenuVo sysMenuVo = new SysMenuVo();
            sysMenuVo.setTitle(sysMenu.getTitle());
            sysMenuVo.setName(sysMenu.getComponent());
            List<SysMenu> children = sysMenu.getChildren();
            if (!CollectionUtils.isEmpty(children)) {
                sysMenuVo.setChildren(buildMenus(children));
            }
            sysMenuVoList.add(sysMenuVo);
        }
        return sysMenuVoList;
    }

}
