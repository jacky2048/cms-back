package com.levon.cms.common.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CrossInterceptor()).addPathPatterns("/**");
        System.out.println("跨域拦截器注册成功");
        registry.addInterceptor(new OptionsInterceptor()).addPathPatterns("/**");
        System.out.println("options拦截器注册成功");
    }
}
