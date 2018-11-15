package com.azuray.decodeme.mapper;

import com.azuray.decodeme.entity.vo.vote.VoteHead;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface VoteHeadMapper extends BaseMapper<VoteHead> {

    int deleteByPrimaryKey(Long voteId);

    int insert(VoteHead record);

    int insertSelective(VoteHead record);

    VoteHead selectByPrimaryKey(Long voteId);

    int updateByPrimaryKeySelective(VoteHead record);

    int updateByPrimaryKey(VoteHead record);
}