package com.azuray.decodeme.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用于验证相关的方法存放
 *
 * @author yb
 * @Date 2018-09-27
 */
public class ValidationUtil {

    /**
     * 验证邮箱是否正确
     *
     * @param email 邮箱
     *
     * @return 正确返回true，错误返回false
     */
    public static boolean validationEmail(String email) {

        String regex = "^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * 验证手机号是否正确
     *
     * @param phone 手机号
     *
     * @return 正确返回true，错误返回false
     */
    public static boolean vaildationPhone(String phone) {
        String regex = "1[3-9]{2}[0-9]{8}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
