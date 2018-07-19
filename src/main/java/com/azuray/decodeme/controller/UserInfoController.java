package com.azuray.decodeme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.azuray.decodeme.common.CommonResponse;
import com.azuray.decodeme.entity.vo.UserInfo;
import com.azuray.decodeme.service.UserInfoService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserInfoController {

  @Autowired
  private UserInfoService userInfoService;

  @RequestMapping(value = "add", method = RequestMethod.POST)
  public CommonResponse addUserInfo(@RequestBody UserInfo userInfo) {
    log.debug("start add user");
    try {
      boolean notUsedFlag = userInfoService.cheackNameOrCodeOrEmailOrPhoneNotUsed(userInfo);
      if (!notUsedFlag) {
        return new CommonResponse("10", "用户名，昵称，邮箱或手机号重复");
      }
      String encode = new BCryptPasswordEncoder().encode(userInfo.getPassword());
      userInfo.setPassword(encode);
      userInfoService.insert(userInfo);

    } catch (Exception e) {
      log.error("add user fail", e.getMessage());
      e.printStackTrace();
      return new CommonResponse("90", "fail");
    }
    log.debug("add user success");
    return new CommonResponse("00", "success");
  }


  private boolean cheackNameOrCodeOrEmailOrPhoneNotUsed(UserInfo user) {
    EntityWrapper<UserInfo> usWrapper = new EntityWrapper<UserInfo>();
    usWrapper.eq(UserInfo.userIdStr, user.getUserCode()).or()
        .eq(UserInfo.userNameStr, user.getUserName()).or()
        .eq(UserInfo.mailStr, user.getMail()).or()
        .eq(UserInfo.phoneStr, user.getPhone());
    UserInfo userInfoInDB = userInfoService.selectOne(usWrapper);
    if (userInfoInDB == null) {
      return true;
    }
    return false;
  }
}
