package com.boca.iot.manager;

import com.boca.iot.manager.properties.MinioProperties;
import com.boca.iot.manager.properties.UserAuthProperties;
import com.boca.iot.manager.utils.log.annotation.EnableLogAspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author lulinwei
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.boca.iot"})
@MapperScan(basePackages = {"com.boca.iot.**.mapper"})
@EnableConfigurationProperties(value = {UserAuthProperties.class, MinioProperties.class})
@EnableAsync
@EnableLogAspect
@EnableScheduling
public class ManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }
}
