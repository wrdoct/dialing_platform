package com.boca.iot.platform.config;


import com.boca.iot.platform.interceptor.LoginAuthInterceptor;
import com.boca.iot.platform.properties.UserAuthProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CORS解决跨域--配置跨域请求
 *
 * @author lulinwei
 */
@Component
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private LoginAuthInterceptor loginAuthInterceptor ;

    @Autowired
    private UserAuthProperties userAuthProperties ;		// 注入实体类对象

    // 拦截器注册
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludePatterns = new String[]{ "/swagger-resources/**", "/webjars/**", "/v3/**", "/doc.html/**" }; // 对swagger(Knife4j)的请求不进行拦截
        registry.addInterceptor(loginAuthInterceptor)
//                .excludePathPatterns("/admin/system/index/login" ,
//                        "/admin/system/index/generateValidateCode") // 哪些不需要拦截
                .excludePathPatterns(userAuthProperties.getNoAuthUrls())
                .addPathPatterns("/**") // 哪些需要拦截
                .excludePathPatterns(excludePatterns);
    }

    // 跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")      // 添加路径规则
                .allowCredentials(true)            // 是否允许在跨域的情况下传递Cookie
                .allowedOrigins("*")               // 允许请求来源的域规则
                .allowedMethods("*")
                .allowedHeaders("*") ;             // 允许所有的请求头
    }

}
