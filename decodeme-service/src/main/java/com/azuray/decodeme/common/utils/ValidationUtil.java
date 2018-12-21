package com.azuray.decodeme.common.utils;

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
    public static boolean validationPhone(String phone) {
        String regex = "1[3-9]{2}[0-9]{8}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    /**
     * 校验日期是否正确
     * @param dateStr 时间 yyyy-MM-dd
     * @return t/f
     */
    public static boolean validationDate(String dateStr) {
        String regex = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateStr);
        return matcher.matches();
    }

    /**
     * 校验日期是否正确
     * @param dateStr 时间 yyyy/MM/dd
     * @return t/f
     */
    public static boolean validationDate2(String dateStr) {
        String regex = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})\\/(((0[13578]|1[02])\\/(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)\\/(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))\\/02-29)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateStr);
        return matcher.matches();
    }
}
