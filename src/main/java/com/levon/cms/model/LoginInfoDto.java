package com.levon.cms.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LoginInfoDto implements Serializable {

    private static final long serialVersionUID = -4802368297596121699L;

    private String username;
    private String password;

}
