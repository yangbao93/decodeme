package com.azuray.decodeme.entity.vo.vote;

import lombok.Data;

import java.util.Date;

@Data
/**
 * 投票主体
 * @auther yb
 */
public class VoteHead {

    private Long voteId;

    private String voteName;

    private String voteNote;

    private Boolean votePrivate;

    private String keywords;

    private String voteUserCode;

    private String voteUserName;

    private Long userNums;

    private Date startTime;

    private Date endTime;

    private Byte isDelete;

    private Date createTime;

    private Date ts;

}