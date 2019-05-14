package com.levon.cms.service.impl;

import com.levon.cms.dao.UserInfoMapper;
import com.levon.cms.entity.UserInfo;
import com.levon.cms.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfo(String loginCode){
        return userInfoMapper.getUserInfo(loginCode);
    }

    @Override
    public boolean isValidUser(String loginCode, String password) {
        UserInfo userInfo = userInfoMapper.getUserInfo(loginCode);
        // TODO 这里需要做加密处理，了解加密算法，并掌握一种加密方式（最好有自己见解的加密方式）
        if ("admin".equals(loginCode) && "123".equals(password)) {
            return true;
        }
        return false;
    }
}
