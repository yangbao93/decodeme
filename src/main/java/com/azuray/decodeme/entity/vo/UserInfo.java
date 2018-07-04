package com.azuray.decodeme.entity.vo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 * author yangbao
 */
@TableName("de_u_userinfo")
public class UserInfo extends Model<UserInfo>{

    private static final long serialVersionUID = 1L;

    @TableId("user_id")
    private Long userId;

    @TableId("user_code")
    private String userCode;

    @TableId("user_name")
    private String userName;

    private String password;

    private String mail;

    private String phone;

    @TableId("createtime")
    private Date createTime;

    private Date ts;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
}
