package com.azuray.decodeme.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.azuray.decodeme.entity.vo.UserInfo;
import com.azuray.decodeme.mapper.UserInfoMapper;
import com.azuray.decodeme.service.UserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Service("userInfoService")
@Slf4j
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper,UserInfo> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public boolean checkNameOrCodeOrEmailOrPhoneNotUsed(UserInfo user) {
        log.debug(String.format("检查用户名:%s,用户编码%s,邮箱%s,手机号:%s是否重复", user.getUserName(), user.getUserCode(),
                user.getMail(), user.getPhone()));
        QueryWrapper<UserInfo> usWrapper = new QueryWrapper<>();
        if (StringUtils.isEmpty(user.getUserCode())) {
            usWrapper.or().eq(UserInfo.userIdStr, user.getUserCode());
        }
        if (StringUtils.isEmpty(user.getUserName())){
            usWrapper.or().eq(UserInfo.userNameStr,user.getUserName());
        }
        if (StringUtils.isEmpty(user.getMail())){
            usWrapper.or().eq(UserInfo.mailStr,user.getMail());
        }
        if (StringUtils.isEmpty(user.getPhone())){
            usWrapper.or().eq(UserInfo.phoneStr,user.getPhone());
        }
        UserInfo userInfoInDB = super.getOne(usWrapper);
        if (userInfoInDB == null) {
            return true;
        }
        return false;
    }
}
