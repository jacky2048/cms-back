package com.levon.cms.common.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Component
@Configuration
@ConfigurationProperties(prefix = "spring.cross")
public class CrossInterceptor implements HandlerInterceptor {

    private static List<String> allowHosts;

    public void setAllow(String allow) {
        if (allow != null) {
            this.allowHosts = Arrays.asList(allow.split(";"));
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String origin = request.getHeader(HttpHeaders.ORIGIN);

        if (!StringUtils.isEmpty(origin)) {
            if (allowHosts.contains(origin)) {
                response.setHeader("Access-Control-Allow-Origin", origin);
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, HEAD");
                response.setHeader("Access-Control-Allow-Headers", "Content-Type, X-Access-Token");
                response.setHeader("Access-Control-Max-Age", "3600");
            } else {
                System.out.println("跨域失败：" + origin);
            }
        }
        return true;
    }

    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowedHeaders("X-Access-Token");
        log.debug("允许跨域配置成功！");
    }
   */
}
