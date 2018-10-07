package com.azuray.decodeme.controller;

import com.azuray.decodeme.common.CommonResponse;
import com.azuray.decodeme.common.ValidationUtil;
import com.azuray.decodeme.constant.ResultCode;
import com.azuray.decodeme.entity.vo.UserInfo;
import com.azuray.decodeme.service.UserInfoService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserInfoController {

    /**
     * 注入类后面全部改成构造函数的方式进行注入
     */
    private final UserInfoService userInfoService;

    @Autowired
    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public CommonResponse addUserInfo(@RequestBody UserInfo userInfo) {
        log.debug("进行用户新增");
        try {
            String checkResult = this.cheackNameOrCodeOrEmailOrPhoneNotUsed(userInfo);
            if (!StringUtils.isEmpty(checkResult)) {
                return new CommonResponse(ResultCode.PARAM_ILLEGAL_CODE, checkResult);
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
        log.debug("用户提交修改信息", userInfo.getUserName());
        if (userInfo == null) {
            return new CommonResponse(ResultCode.PARAM_ILLEGAL_CODE, ResultCode.PARAM_ILLEGAL_MSG);
        }
        // todo 获取当前用户的信息
        String userId = "";
        UserInfo userInfoDb = userInfoService.selectById(userId);
        // 有且只能修改昵称，邮箱，手机号
        if (!StringUtils.isEmpty(userInfo.getUserName())) {
            userInfoDb.setUserName(userInfo.getUserName());
        }
        if ((!StringUtils.isEmpty(userInfo.getMail())) && ValidationUtil.validationEmail(userInfo.getMail())) {
            userInfoDb.setMail(userInfo.getMail());
        }
        if ((!StringUtils.isEmpty(userInfo.getPhone())) && ValidationUtil.vaildationPhone(userInfo.getPhone())) {
            userInfoDb.setPhone(userInfo.getPhone());
        }
        // 更新DB
        boolean result = userInfoService.updateById(userInfoDb);
        if (result) {
            return new CommonResponse(ResultCode.SUCCESS_CODE, ResultCode.SUCCESS_MSG);
        }
        return new CommonResponse(ResultCode.FAIL_CODE, ResultCode.FAIL_MSG);
    }

    /**
     * 检查用户名，账号，邮箱，手机号是否被使用
     *
     * @param user 参数信息
     *
     * @return 返回结果
     */
    private String cheackNameOrCodeOrEmailOrPhoneNotUsed(UserInfo user) {
        EntityWrapper<UserInfo> usWrapper = new EntityWrapper<UserInfo>();
        usWrapper.eq(UserInfo.userCodeStr, user.getUserCode());
        int count = 0;
        count = userInfoService.selectCount(usWrapper);
        if (count > 0) {
            return "用户名已被使用！";
        }
        usWrapper.or().eq(UserInfo.userNameStr, user.getUserName());
        count = userInfoService.selectCount(usWrapper);
        if (count > 0) {
            return "昵称已被使用！";
        }
        usWrapper.or().eq(UserInfo.mailStr, user.getMail());
        count = userInfoService.selectCount(usWrapper);
        if (count > 0) {
            return "邮箱已被使用！";
        }
        usWrapper.or().eq(UserInfo.phoneStr, user.getPhone());
        count = userInfoService.selectCount(usWrapper);
        if (count > 0) {
            return "手机号已被使用！";
        }
        return null;
    }
}
