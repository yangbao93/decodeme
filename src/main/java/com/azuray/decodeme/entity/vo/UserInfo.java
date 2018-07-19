package com.azuray.decodeme.entity.vo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 * author yangbao
 */
@TableName("de_u_userinfo")
@Data
public class UserInfo extends Model<UserInfo>{

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id",type = IdType.AUTO)
    private Long userId;
    public static String userIdStr = "user_id";

    @TableField("user_code")
    private String userCode;
    public static String userCodeStr = "user_code";

    @TableField("user_name")
    private String userName;
    public static String userNameStr = "user_name";

    private String password;
    public static String passwordStr = "password";

    private String mail;
    public static String mailStr = "mail";

    private String phone;
    public static String phoneStr = "phone";

    @TableField("createtime")
    private Date createTime;

    private Date ts;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
}
