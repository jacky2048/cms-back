package com.levon.cms.dao;

import com.levon.cms.entity.UserInfo;

public interface UserInfoMapper {

    UserInfo getUserInfo(String loginCode);
}
