package com.levon.cms.service;

import com.levon.cms.common.annotation.DataBase;
import com.levon.cms.entity.UserInfo;

public interface UserInfoService {

    @DataBase("db2")
    UserInfo getUserInfo(String loginCode);

    boolean isValidUser(String loginCode, String password);
}
