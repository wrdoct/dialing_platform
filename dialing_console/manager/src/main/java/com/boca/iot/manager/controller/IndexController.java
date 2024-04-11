package com.boca.iot.manager.controller;


import com.boca.iot.manager.model.dto.system.LoginDto;
import com.boca.iot.manager.model.vo.common.Result;
import com.boca.iot.manager.model.vo.common.ResultCodeEnum;
import com.boca.iot.manager.model.vo.system.LoginVo;
import com.boca.iot.manager.model.vo.system.SysMenuVo;
import com.boca.iot.manager.model.vo.system.ValidateCodeVo;
import com.boca.iot.manager.service.SysMenuService;
import com.boca.iot.manager.service.SysUserService;
import com.boca.iot.manager.service.ValidateCodeService;
import com.boca.iot.manager.utils.AuthContextUtil;
import com.boca.iot.manager.utils.log.annotation.Log;
import com.boca.iot.manager.utils.log.enums.BusinessType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lulinwei
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping(value = "/admin/system/index")
public class IndexController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ValidateCodeService validateCodeService;

    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation(value = "用户退出")
    @GetMapping(value = "/logout")
    public Result logout(@RequestHeader(value = "token") String token) {
        sysUserService.logout(token) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping(value = "/getUserInfo")
    public Result getUserInfo() {
        return Result.build(AuthContextUtil.get(), ResultCodeEnum.SUCCESS);
    }

    @ApiOperation(value = "生成图片验证码")
    @GetMapping(value = "/generateValidateCode")
    public Result<ValidateCodeVo> generateValidateCode() {
        ValidateCodeVo validateCodeVo = validateCodeService.generateValidateCode();
        return Result.build(validateCodeVo , ResultCodeEnum.SUCCESS) ;
    }

    @ApiOperation(value = "登录接口")
    @PostMapping("/login")
    public Result login(@RequestBody LoginDto loginDto){
        LoginVo loginvo = sysUserService.login(loginDto);
        return Result.build(loginvo, ResultCodeEnum.SUCCESS);
    }

    @Log(title = "查询用户系统菜单列表", businessType = BusinessType.FIND)
    @ApiOperation(value = "查询用户系统菜单列表")
    @GetMapping("/menus")
    public Result menus() {
        List<SysMenuVo> sysMenuVoList =  sysMenuService.findUserMenuList() ;
        return Result.build(sysMenuVoList , ResultCodeEnum.SUCCESS) ;
    }

}
