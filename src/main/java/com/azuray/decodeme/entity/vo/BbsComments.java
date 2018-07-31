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
 * 论坛评论信息
 * @author yb
 */
@Data
@TableName(value = "bbs_comments")
public class BbsComments extends Model<BbsComments> {

    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField(value = "comment_context")
    private String commentContext;

    @TableField(value = "comment_belong_user")
    private String commentBelongUser;

    @TableField(value = "enable_view")
    private boolean enableView;

    @TableField(value = "enable_comment")
    private boolean enableComment;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "ts")
    private Date ts;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
