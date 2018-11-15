package com.azuray.decodeme.entity.vo.vote;

import lombok.Data;

import java.util.Date;

@Data
/**
 * 投票主体
 * @auther yb
 */
public class VoteTopic {

    private Long voteTopicId;

    private Long votePid;

    private Integer topicOrder;

    private String topicName;

    private String topicNote;

    private Integer topicType;

    private String topicValue;

    private Integer topicNext;

    private Date createTime;

    private Date ts;
}