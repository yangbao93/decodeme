package com.azuray.decodeme.common;

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
}
