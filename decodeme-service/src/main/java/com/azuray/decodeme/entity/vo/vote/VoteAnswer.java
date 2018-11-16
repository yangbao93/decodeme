package com.azuray.decodeme.entity.vo.vote;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("vote_answer")
public class VoteAnswer extends Model<VoteAnswer> {

    private Long voteAnsId;

    private Long voteId;

    private Long voteTopicId;

    private Long voteChoId;

    private String ansValue;

    private String ansUserName;

    private String ansUserCode;

    private Date createTime;

    private Date ts;

    @Override
    protected Serializable pkVal() {
        return voteAnsId;
    }
}