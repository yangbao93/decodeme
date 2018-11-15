package com.azuray.decodeme.service.impl;

import com.azuray.decodeme.entity.vo.vote.VoteTopic;
import com.azuray.decodeme.mapper.VoteTopicMapper;
import com.azuray.decodeme.service.VoteTopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("voteTopicService")
@Slf4j
public class VoteTopicServiceImpl extends ServiceImpl<VoteTopicMapper, VoteTopic> implements VoteTopicService {
}
