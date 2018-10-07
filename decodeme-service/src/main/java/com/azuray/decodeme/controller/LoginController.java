package com.azuray.decodeme.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/com/azuray/decodeme")
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void userLogin() {
        // todo 根据用户名，密码，验证码进行登录操作
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void userLogout() {
        // todo 获取当前用户信息，清除登录信息
    }
}
