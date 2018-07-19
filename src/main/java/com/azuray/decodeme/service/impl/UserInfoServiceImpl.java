package com.azuray.decodeme.service.impl;

import com.azuray.decodeme.entity.vo.UserInfo;
import com.azuray.decodeme.mapper.UserInfoMapper;
import com.azuray.decodeme.service.UserInfoService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper,UserInfo> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public boolean cheackNameOrCodeOrEmailOrPhoneNotUsed(UserInfo user) {

        EntityWrapper<UserInfo> usWrapper = new EntityWrapper<UserInfo>();
        if (StringUtils.isEmpty(user.getUserCode())){
            usWrapper.or().eq(UserInfo.userIdStr,user.getUserCode());
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
        UserInfo userInfoInDB = super.selectOne(usWrapper);
        if (userInfoInDB == null) {
            return true;
        }
        return false;
    }
}
