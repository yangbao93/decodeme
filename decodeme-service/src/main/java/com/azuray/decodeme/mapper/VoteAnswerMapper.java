package com.azuray.decodeme.mapper;

import com.azuray.decodeme.entity.vo.vote.VoteAnswer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface VoteAnswerMapper extends BaseMapper<VoteAnswer> {

    int deleteByPrimaryKey(Long voteAnsId);

    int insert(VoteAnswer record);

    int insertSelective(VoteAnswer record);

    VoteAnswer selectByPrimaryKey(Long voteAnsId);

    int updateByPrimaryKeySelective(VoteAnswer record);

    int updateByPrimaryKey(VoteAnswer record);
}