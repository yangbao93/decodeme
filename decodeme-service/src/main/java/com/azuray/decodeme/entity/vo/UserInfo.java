package com.azuray.decodeme.entity.vo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户信息
 * author yangbao
 */
@EqualsAndHashCode(callSuper = true)
@TableName("de_u_userinfo")
@Data
public class UserInfo extends Model<UserInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.UUID)
    private String userId;

    @TableField("user_code")
    private String userCode;

    @TableField("user_name")
    private String userName;

    @TableField("password")
    private String password;

    @TableField("salt")
    private String salt;

    @TableField("mail")
    private String mail;

    @TableField("phone")
    private String phone;

    @TableField("createtime")
    private Date createTime;

    @TableField("is_delete")
    private Byte isDelete;

    @TableField("ts")
    private Date ts;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    public static String userIdStr = "user_id";
    public static String userCodeStr = "user_code";
    public static String userNameStr = "user_name";
    public static String passwordStr = "password";
    public static String saltStr = "salt";
    public static String mailStr = "mail";
    public static String phoneStr = "phone";
    public static String createTimeStr = "createTime";
    public static String isDeleteStr = "is_delete";
}
