package com.azuray.decodeme.entity.vo.bbs;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 论坛评论信息
 *
 * @author yb
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "bbs_comments")
public class BbsComments extends Model<BbsComments> {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String commentContext;

    private String commentBelongUser;

    private boolean enableView;

    private boolean enableComment;

    private Date createTime;

    private Date ts;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
