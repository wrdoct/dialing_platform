//package com.boca.iot.config;
//
//import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
//import org.apache.shiro.mgt.DefaultSubjectDAO;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.filter.authz.SslFilter;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.filter.DelegatingFilterProxy;
//
//import javax.servlet.Filter;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * @author lulinwei
// */
//@Configuration
//public class ShiroConfig {
//
//    @Bean(name = "shiroFilter")
//    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager) {
//        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
//        Map<String, Filter> filters = new HashMap<>(2);
//        filters.put("ssl", new SslFilter());
//        filters.put("jwt", new JwtFilter());
//        shiroFilter.setFilters(filters);
//        shiroFilter.setLoginUrl("/sec/login");
//        shiroFilter.setSecurityManager(manager);
//        shiroFilter.setUnauthorizedUrl("/sec/401");
//
//        // 配置访问权限
//        LinkedHashMap<String, String> filterRules = new LinkedHashMap<>();
//        filterRules.put("/webjars/**", "anon");
//        filterRules.put("/swagger**", "anon");
//        filterRules.put("/v2/api-docs", "anon");
//        filterRules.put("/swagger-resources/configuration/ui", "anon");
//        filterRules.put("/doc.html", "anon");
//
//        filterRules.put("/**", "jwt");
//        shiroFilter.setFilterChainDefinitionMap(filterRules);
//        return shiroFilter;
//    }
//
//    /**
//     * 配置核心安全事务管理器
//     */
//    @Bean(name = "securityManager")
//    public SecurityManager securityManager() {
//        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
//        manager.setRealm(jwtRealm());
//        // 关闭shiro默认的sessionDao
//        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
//        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
//        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
//        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
//        manager.setSubjectDAO(subjectDAO);
//        return manager;
//    }
//
//    /**
//     * 配置自定义的权限登录器
//     */
//    @Bean(name = "jwtRealm")
//    public JwtRealm jwtRealm() {
//        JwtRealm jwtRealm = new JwtRealm();
//        return jwtRealm;
//    }
//
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
//        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
//        filterRegistration.setEnabled(true);
//        filterRegistration.setOrder(1);
//        filterRegistration.addUrlPatterns("/*");
//        return filterRegistration;
//    }
//
//    @Bean
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
//
//    @Bean
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
//        creator.setProxyTargetClass(true);
//        return creator;
//    }
//
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager) {
//        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
//        advisor.setSecurityManager(manager);
//        return advisor;
//    }
//}
