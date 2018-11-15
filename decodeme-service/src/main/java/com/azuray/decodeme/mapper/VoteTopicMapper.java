package com.azuray.decodeme.mapper;

import com.azuray.decodeme.entity.vo.vote.VoteTopic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface VoteTopicMapper extends BaseMapper<VoteTopic> {
    int deleteByPrimaryKey(Long voteTopicId);

    int insert(VoteTopic record);

    int insertSelective(VoteTopic record);

    VoteTopic selectByPrimaryKey(Long voteTopicId);

    int updateByPrimaryKeySelective(VoteTopic record);

    int updateByPrimaryKey(VoteTopic record);
}