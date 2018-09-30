package com.azuray.decodeme.entity.vo.bbs;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;

/**
 * 论坛评论信息
 *
 * @author yb
 */
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
