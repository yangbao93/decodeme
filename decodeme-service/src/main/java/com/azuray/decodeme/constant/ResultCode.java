package com.azuray.decodeme.constant;

/**
 * 返回结果code/msg
 */
public interface ResultCode {

    /**
     * 操作成功
     */
    Integer SUCCESS_CODE = 1000;
    String SUCCESS_MSG = "操做成功";
    /**
     * 信息为空
     */
    Integer NULL_CODE = 4001;
    String NULL_MSG = "信息为空";
    /**
     * 非法参数
     */
    Integer PARAM_ILLEGAL_CODE = 4002;
    String PARAM_ILLEGAL_MSG = "非法参数";
    /**
     * 操作失败
     */
    Integer FAIL_CODE = 9999;
    String FAIL_MSG = "操作失败";

}
