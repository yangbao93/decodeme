package com.azuray.decodeme.entity.vo.vote;

import lombok.Data;

import java.util.Date;

@Data
public class VoteAnswer {

    private Long voteAnsId;

    private Long voteId;

    private Long voteTopicId;

    private Long voteChoId;

    private String ansValue;

    private String ansUserName;

    private String ansUserCode;

    private Date createTime;

    private Date ts;
}