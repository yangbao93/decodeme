package com.azuray.decodeme.mapper;

import com.azuray.decodeme.entity.vo.vote.VoteChoose;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface VoteChooseMapper extends BaseMapper<VoteChoose> {
    int deleteByPrimaryKey(Long voteChoId);

    int insert(VoteChoose record);

    int insertSelective(VoteChoose record);

    VoteChoose selectByPrimaryKey(Long voteChoId);

    int updateByPrimaryKeySelective(VoteChoose record);

    int updateByPrimaryKey(VoteChoose record);
}