package com.azuray.decodeme.common;

import java.io.Serializable;

import lombok.Data;

@Data
public class CommonResponse implements Serializable {

    private static final long serialVersionUID = 8726644005882171717L;

    private Integer code;

    private String msg;

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
