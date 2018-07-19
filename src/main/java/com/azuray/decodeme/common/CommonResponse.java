package com.azuray.decodeme.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommonResponse implements Serializable {

    private static final long serialVersionUID = 8726644005882171717L;

    private String code;

    private String msg;

    private Object data;

    private CommonResponse() {

    }

    public CommonResponse(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public CommonResponse(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
