package com.boca.iot.manager.controller;

import com.boca.iot.manager.model.dto.system.AssginRoleDto;
import com.boca.iot.manager.model.dto.system.SysUserDto;
import com.boca.iot.manager.model.entity.system.SysRole;
import com.boca.iot.manager.model.entity.system.SysUser;
import com.boca.iot.manager.model.vo.common.Result;
import com.boca.iot.manager.model.vo.common.ResultCodeEnum;
import com.boca.iot.manager.service.SysUserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lulinwei
 */
@Slf4j
@Api(tags = "系统管理--用户管理接口")
@RestController
@RequestMapping(value = "/admin/system/sysUser")
public class SysUserController {

    @Resource
    private SysUserService sysUserService ;

    @ApiOperation(value = "分页用户列表")
    @GetMapping(value = "/findByPage/{pageNum}/{pageSize}")
    public Result<PageInfo<SysRole>> findByPage(SysUserDto sysUserDto ,
                                                @PathVariable(value = "pageNum") Integer pageNum ,
                                                @PathVariable(value = "pageSize") Integer pageSize) {
        PageInfo<SysUser> pageInfo = sysUserService.findByPage(sysUserDto , pageNum , pageSize) ;
        return Result.build(pageInfo , ResultCodeEnum.SUCCESS) ;
    }

    @ApiOperation(value = "添加用户")
    @PostMapping(value = "/saveSysUser")
    public Result saveSysUser(@RequestBody SysUser sysUser) {
        sysUserService.saveSysUser(sysUser) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    @ApiOperation(value = "修改用户")
    @PutMapping(value = "/updateSysUser")
    public Result updateSysUser(@RequestBody SysUser sysUser) {
        sysUserService.updateSysUser(sysUser) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping(value = "/deleteById/{userId}")
    public Result deleteById(@PathVariable(value = "userId") Long userId) {
        sysUserService.deleteById(userId) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    @ApiOperation(value = "分配角色")
    @PostMapping("/doAssign")
    public Result doAssign(@RequestBody AssginRoleDto assginRoleDto) {
        sysUserService.doAssign(assginRoleDto) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

}
