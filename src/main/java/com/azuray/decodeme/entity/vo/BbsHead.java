package com.azuray.decodeme.entity.vo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;

/**
 * 论坛头部信息
 * @author yb
 */
@Data
@TableName(value = "bbs_head")
public class BbsHead extends Model<BbsHead> {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 标题名称
     */
    @TableField(value = "head_name")
    private String headName;

    /**
     * 标题关键字
     */
    @TableField(value = "head_key_words")
    private String headKeyWords;

    /**
     * 帖子所属人
     */
    @TableField(value = "belong_user")
    private String belongUser;

    /**
     * 开启评论
     */
    @TableField(value = "enable_comment")
    private boolean enableComment;

    /**
     * 创建时间
     */
    @TableField(value = "createtime")
    private Date createTime;

    /**
     * 时间戳
     */
    @TableField(value = "ts")
    private Date ts;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
