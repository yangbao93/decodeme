package com.azuray.decodeme.entity.vo.vote;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 投票选项
 * @auther yb
 */
@Data
@TableName("vote_choose")
public class VoteChoose extends Model<VoteChoose> {

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

    @Override
    protected Serializable pkVal() {
        return voteChoId;
    }
}