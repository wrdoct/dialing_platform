package com.boca.iot.platform.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author lulinwei
 */
@Data
@ConfigurationProperties(prefix = "dialing.auth") // 前缀不能使用驼峰命名
public class UserAuthProperties {

    private List<String> noAuthUrls;

}
