package com.azuray.decodeme.entity.vo.vote;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 投票主体
 *
 * @auther yb
 */
@Data
@TableName("vote_head")
public class VoteHead extends Model<VoteHead> {
    /**
     * 主键id
     */
    private Long voteId;
    /**
     * 名称
     */
    private String voteName;
    /**
     * 备注内容
     */
    private String voteNote;
    /**
     * 投票类型
     */
    private String voteType;
    /**
     * 关键字
     */
    private String keywords;
    /**
     * 用户编码
     */
    private String voteUserCode;
    /**
     * 用户名称
     */
    private String voteUserName;
    /**
     * 是否私人
     */
    private Boolean isPrivate;
    /**
     * 是否匿名
     */
    private Boolean isAnonymous;
    /**
     * 是否删除
     */
    private Boolean isDelete;
    /**
     * 参与人数
     */
    private Long userNums;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 时间戳
     */
    private Date ts;

    @Override
    protected Serializable pkVal() {
        return voteId;
    }
}