package com.boca.iot.manager.service;


import com.boca.iot.manager.model.vo.system.ValidateCodeVo;

/**
 * @author lulinwei
 */
public interface ValidateCodeService {

    // 生成图片验证码
    ValidateCodeVo generateValidateCode();
}
