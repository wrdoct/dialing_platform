package com.boca.iot.platform.service;


import com.boca.iot.platform.model.vo.system.ValidateCodeVo;

/**
 * @author lulinwei
 */
public interface ValidateCodeService {

    // 生成图片验证码
    ValidateCodeVo generateValidateCode();
}
