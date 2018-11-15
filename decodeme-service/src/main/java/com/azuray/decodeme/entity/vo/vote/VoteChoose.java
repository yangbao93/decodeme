package com.azuray.decodeme.entity.vo.vote;

import lombok.Data;

import java.util.Date;

@Data
/**
 * 投票选项
 * @auther yb
 */
public class VoteChoose {

    private Long voteChoId;

    private Long voteTopicId;

    private Long voteId;

    private Integer choOrder;

    private String choName;

    private String choNote;

    private String choValue;

    private Integer choNext;

    private Date createTime;

    private Date ts;

}