package com.levon.cms.common.core;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: Axios请求时，偶尔会遇到一个 api请求两次的情况，其实第一次是 Options 请求，我们也可以用拦截器同意处理 Options请求
 * @author: levon
 * @createDate: 2019-04-10 20:44
 */
public class OptionsInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getMethod().contains("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return false;
        }
        return true;
    }
}
