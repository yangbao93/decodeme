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
 * 用户信息
 * author yangbao
 */
@TableName("de_u_userinfo")
@Data
public class UserInfo extends Model<UserInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.UUID)
    private String userId;
    public static String userIdStr = "user_id";

    @TableField("user_code")
    private String userCode;
    public static String userCodeStr = "user_code";

    @TableField("user_name")
    private String userName;
    public static String userNameStr = "user_name";

    @TableField("password")
    private String password;
    public static String passwordStr = "password";

    @TableField("salt")
    private String salt;
    public static String saltStr = "salt";

    @TableField("mail")
    private String mail;
    public static String mailStr = "mail";

    @TableField("phone")
    private String phone;
    public static String phoneStr = "phone";

    @TableField("createtime")
    private Date createTime;
    public static String createTimeStr = "createTime";

    @TableField("is_delete")
    private Byte isDelete;
    public static String isDeleteStr = "is_delete";

    @TableField("ts")
    private Date ts;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
}
