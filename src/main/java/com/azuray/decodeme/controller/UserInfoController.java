package com.azuray.decodeme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.azuray.decodeme.common.CommonResponse;
import com.azuray.decodeme.constant.ResultCode;
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
        log.debug("进行用户新增");
        try {
            boolean notUsedFlag = userInfoService.cheackNameOrCodeOrEmailOrPhoneNotUsed(userInfo);
            if (!notUsedFlag) {
                return new CommonResponse(ResultCode.PARAM_ILLEGAL_CODE, "用户名，昵称，邮箱或手机号重复");
            }
            String encode = new BCryptPasswordEncoder().encode(userInfo.getPassword());
            userInfo.setPassword(encode);
            userInfoService.insert(userInfo);
        } catch (Exception e) {
            log.error("添加用户失败", e.getMessage());
            e.printStackTrace();
            return new CommonResponse(ResultCode.FAIL_CODE, ResultCode.FAIL_MSG);
        }
        log.debug("添加用户成功");
        return new CommonResponse(ResultCode.SUCCESS_CODE, ResultCode.SUCCESS_MSG);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public CommonResponse updateUserInfo(@RequestBody UserInfo userInfo) {
        // 仅仅可以修改邮箱，手机号，昵称
        log.debug("用户提交修改信息", userInfo.getUserName());
        if (userInfo == null) {
            return new CommonResponse(ResultCode.PARAM_ILLEGAL_CODE, ResultCode.PARAM_ILLEGAL_MSG);
        }
        // todo 获取当前用户的信息
        // todo 修改对应的信息
        // todo 存放db
        return null;
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
