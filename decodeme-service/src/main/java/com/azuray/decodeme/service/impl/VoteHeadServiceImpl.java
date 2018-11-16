package com.azuray.decodeme.service.impl;

import com.azuray.decodeme.entity.vo.vote.VoteHead;
import com.azuray.decodeme.mapper.VoteHeadMapper;
import com.azuray.decodeme.service.VoteHeadService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("VoteHeadService")
@Slf4j
public class VoteHeadServiceImpl extends ServiceImpl<VoteHeadMapper, VoteHead> implements VoteHeadService {
}
