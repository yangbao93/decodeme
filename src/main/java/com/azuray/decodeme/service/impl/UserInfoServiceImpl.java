package com.azuray.decodeme.service.impl;

import com.azuray.decodeme.service.UserInfoService;
import com.azuray.decodeme.dao.UserInfoMapper;
import com.azuray.decodeme.entity.vo.UserInfo;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper,UserInfo> implements UserInfoService {
}
