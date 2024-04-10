package com.boca.iot.manager;

import com.boca.iot.manager.properties.MinioProperties;
import com.boca.iot.manager.properties.UserAuthProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lulinwei
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.boca.iot"})
@MapperScan(basePackages = {"com.boca.iot.**.mapper"})
@EnableConfigurationProperties(value = {UserAuthProperties.class, MinioProperties.class})
public class ManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }
}
