package com.azuray.decodeme.service.impl;

import com.azuray.decodeme.entity.vo.vote.VoteAnswer;
import com.azuray.decodeme.mapper.VoteAnswerMapper;
import com.azuray.decodeme.service.VoteAnswerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("voteAnswerService")
@Slf4j
public class VoteAnswerServiceImpl extends ServiceImpl<VoteAnswerMapper, VoteAnswer> implements VoteAnswerService {
}
