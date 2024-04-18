package com.boca.iot.platform.controller;

import com.boca.iot.platform.model.dto.system.AssginRoleDto;
import com.boca.iot.platform.model.dto.system.SysUserDto;
import com.boca.iot.platform.model.entity.system.SysRole;
import com.boca.iot.platform.model.entity.system.SysUser;
import com.boca.iot.platform.model.vo.common.Result;
import com.boca.iot.platform.model.vo.common.ResultCodeEnum;
import com.boca.iot.platform.service.SysUserService;
import com.boca.iot.platform.utils.log.annotation.Log;
import com.boca.iot.platform.utils.log.enums.BusinessType;
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

    @Log(title = "分页用户列表", businessType = BusinessType.FIND)
    @ApiOperation(value = "分页用户列表")
    @GetMapping(value = "/findByPage")
    public Result<PageInfo<SysRole>> findByPage(SysUserDto sysUserDto ,
                                                @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum ,
                                                @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        PageInfo<SysUser> pageInfo = sysUserService.findByPage(sysUserDto , pageNum , pageSize) ;
        return Result.build(pageInfo , ResultCodeEnum.SUCCESS) ;
    }

    @Log(title = "添加用户", businessType = BusinessType.ADD)
    @ApiOperation(value = "添加用户")
    @PostMapping(value = "/saveSysUser")
    public Result saveSysUser(@RequestBody SysUser sysUser) {
        sysUserService.saveSysUser(sysUser) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    @Log(title = "修改用户", businessType = BusinessType.EDIT)
    @ApiOperation(value = "修改用户")
    @PutMapping(value = "/updateSysUser")
    public Result updateSysUser(@RequestBody SysUser sysUser) {
        sysUserService.updateSysUser(sysUser) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    @Log(title = "删除用户", businessType = BusinessType.DELETE)
    @ApiOperation(value = "删除用户")
    @DeleteMapping(value = "/deleteById/{userId}")
    public Result deleteById(@PathVariable(value = "userId") Long userId) {
        sysUserService.deleteById(userId) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    @Log(title = "分配角色", businessType = BusinessType.DEFAULT)
    @ApiOperation(value = "分配角色")
    @PostMapping("/doAssign")
    public Result doAssign(@RequestBody AssginRoleDto assginRoleDto) {
        sysUserService.doAssign(assginRoleDto) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

}
