package com.azuray.decodeme.entity.vo;

import lombok.Data;

@Data
public class LoginUser {
    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 用户密码
     */
    private String userPw;
    /**
     * 验证码
     */
    private String verificationCode;
}
