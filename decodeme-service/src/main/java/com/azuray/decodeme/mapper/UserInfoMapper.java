package com.azuray.decodeme.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.azuray.decodeme.entity.vo.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Repository
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
