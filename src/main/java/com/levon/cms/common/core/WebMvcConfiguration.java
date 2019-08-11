package com.levon.cms.common.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    public static final Logger LOGGER = LoggerFactory.getLogger(WebMvcConfiguration.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CrossInterceptor()).addPathPatterns("/**");
        LOGGER.info("跨域拦截器注册成功");
        registry.addInterceptor(new OptionsInterceptor()).addPathPatterns("/**");
        LOGGER.info("options拦截器注册成功");
    }
}
