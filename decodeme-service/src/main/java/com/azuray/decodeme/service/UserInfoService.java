package com.azuray.decodeme.service;

import com.azuray.decodeme.entity.vo.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserInfoService extends IService<UserInfo> {

    boolean cheackNameOrCodeOrEmailOrPhoneNotUsed(UserInfo userInfo);
}
