package com.azuray.decodeme.service.impl;

import com.azuray.decodeme.entity.vo.vote.VoteChoose;
import com.azuray.decodeme.mapper.VoteChooseMapper;
import com.azuray.decodeme.service.VoteChooseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("voteChooseService")
@Slf4j
public class VoteChooseServiceImpl extends ServiceImpl<VoteChooseMapper, VoteChoose> implements VoteChooseService {
}
