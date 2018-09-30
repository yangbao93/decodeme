package com.azuray.decodeme.entity.vo.bbs;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    private String headName;

    /**
     * 标题关键字
     */
    private String headKeyWords;

    /**
     * 帖子所属人
     */
    private String belongUser;

    /**
     * 开启评论
     */
    private boolean enableComment;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 时间戳
     */
    private Date ts;

    /**
     * 评论
     */
    @TableField(exist = false)
    private List<BbsComments> commentsList;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
