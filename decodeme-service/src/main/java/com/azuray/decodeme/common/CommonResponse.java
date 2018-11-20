package com.azuray.decodeme.common;

import com.alibaba.fastjson.JSONObject;
import com.azuray.decodeme.constant.ResultCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "返回响应数据")
public class CommonResponse implements Serializable {

    private static final long serialVersionUID = 8726644005882171717L;

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "状态描述")
    private String msg;

    @ApiModelProperty(value = "返回数据")
    private Object data;

    private CommonResponse() {

    }

    public CommonResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResponse(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 通用成功返回信息
     *
     * @param data 类容
     * @return 成功信息
     */
    public static CommonResponse successResponse(Object data) {
        if (data == null) {
            return new CommonResponse(ResultCode.SUCCESS_CODE, ResultCode.SUCCESS_MSG);
        }
        return new CommonResponse(ResultCode.SUCCESS_CODE, ResultCode.SUCCESS_MSG, data);
    }

    /**
     * 通用失败返回信息
     *
     * @param data 失败内容
     * @return
     */
    public static CommonResponse failResponse(Object... data) {
        String failMsg = ResultCode.FAIL_MSG;
        if (data != null) {
            failMsg = JSONObject.toJSONString(data);
        }
        return new CommonResponse(ResultCode.FAIL_CODE, failMsg);
    }
}
