package com.boca.iot.platform.service.impl;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.boca.iot.platform.model.vo.system.ValidateCodeVo;
import com.boca.iot.platform.service.ValidateCodeService;
import com.boca.iot.platform.utils.RedisConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author lulinwei
 */
@Service
public class ValidateCodeServiceImpl implements ValidateCodeService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public ValidateCodeVo generateValidateCode() {

        // 使用hutool工具包中的工具类生成图片验证码
        //参数：宽  高  验证码位数 干扰线数量
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(150, 48, 4, 10);
        String codeValue = circleCaptcha.getCode(); // 4位验证码值
        String imageBase64 = circleCaptcha.getImageBase64(); // 返回图片验证码，base64编码
        // 生成uuid作为图片验证码的key
        String codeKey = UUID.randomUUID().toString().replaceAll("-", "");
        // 将验证码存储到Redis中 // key: uuid    value: 验证码值
        redisTemplate.opsForValue()
                .set(RedisConstantsUtil.USER_LOGIN_VALIDATECODE + codeKey,
                        codeValue,
                        5,
                        TimeUnit.MINUTES);
        // 构建响应结果数据并返回
        ValidateCodeVo validateCodeVo = new ValidateCodeVo();
        validateCodeVo.setCodeKey(codeKey);
        validateCodeVo.setCodeValue("data:image/png;base64," + imageBase64);
        return validateCodeVo;
    }

}
