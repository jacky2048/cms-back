package com.levon.cms.controller;

import com.levon.cms.common.core.ResponseUtils;
import com.levon.cms.common.core.RetResult;
import com.levon.cms.entity.UserInfo;
import com.levon.cms.model.LoginInfoDto;
import com.levon.cms.service.UserInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/user")
    @ResponseBody
    public RetResult<UserInfo> test() {
        System.out.println("访问成功");
        UserInfo userInfo = userInfoService.getUserInfo("admin");
        return ResponseUtils.responseData(userInfo);
    }

    @RequestMapping(value = "/login", produces = { "application/json; charset=UTF-8" }, method = RequestMethod.POST)
    @ResponseBody
    public RetResult<Boolean> login(@Valid @RequestBody LoginInfoDto dto) {
        System.out.println("登录请求");
        if (dto != null) {
            boolean isValidUser = userInfoService.isValidUser(dto.getUsername(), dto.getPassword());
            return ResponseUtils.responseData(isValidUser);
        }
        return ResponseUtils.responseFailure();
    }
}
