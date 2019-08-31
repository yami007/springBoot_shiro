package com.yami.springbootshiro.config;

import com.yami.springbootshiro.shiro.CredentialMatcher;
import com.yami.springbootshiro.shiro.AuthRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {

    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        //登录页面
        factoryBean.setLoginUrl("/login");
        // 登录成功页面
        factoryBean.setSuccessUrl("/index");
        // 无权限页面
        factoryBean.setUnauthorizedUrl("/unauthorized");

        LinkedHashMap<String, String> filterChainDefinitonMap = new LinkedHashMap<>();
        filterChainDefinitonMap.put("/index", "authc");
        filterChainDefinitonMap.put("/login", "anon");
        filterChainDefinitonMap.put("/loginUser", "anon");
        filterChainDefinitonMap.put("/admin", "roles[admin]");
        filterChainDefinitonMap.put("/edit", "perms[edit]");
        filterChainDefinitonMap.put("/druid/**", "anon");
        filterChainDefinitonMap.put("/**", "user");
        factoryBean.setFilterChainDefinitionMap(filterChainDefinitonMap);
        return factoryBean;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(authRealm);
        return manager;
    }

    @Bean("authRealm")
    public AuthRealm authRealm(@Qualifier("credentialMatcher") CredentialMatcher matcher) {
        AuthRealm authRealm = new AuthRealm();
        authRealm.setCredentialsMatcher(matcher);
        return authRealm;
    }

    @Bean("credentialMatcher")
    public CredentialMatcher credentialMatcher() {
        return new CredentialMatcher();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator creator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }
}
