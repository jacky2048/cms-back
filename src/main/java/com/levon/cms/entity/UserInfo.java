package com.levon.cms.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserInfo {

    private Long userId;
    private String loginCode;
    private String loginName;
    private String password;
    private String telPhone;
    private String photo;
    private LocalDate createTime;
    private LocalDate updateTime;

}
