package com.azuray.decodeme.entity.vo.vote;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 暂时弃用（原设计为测试使用，现阶段只做投票。直接通过head作为投票题目，
 * choose作为选项，后续需要在head里增加type字段，用来控制是否是多选）
 * @auther yb
 */
@Data
@TableName("vote_topic")
@Deprecated
public class VoteTopic extends Model<VoteTopic> {

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

    @Override
    protected Serializable pkVal() {
        return voteTopicId;
    }
}