package com.azuray.decodeme.controller;

import com.azuray.decodeme.service.UserInfoService;
import com.azuray.decodeme.entity.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public void addUserInfo(UserInfo userInfo){
        userInfoService.insert(userInfo);
    }
}
