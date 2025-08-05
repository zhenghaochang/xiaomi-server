package com.zhc.common.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private Integer code;           //200为成功，其他失败
    private String msg;
    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> reuslt = new Result<T>();
        reuslt.data = data;
        reuslt.code = 200;
        return reuslt;
    }

    public static <T> Result<T> success() {
        Result<T> reuslt = new Result<T>();
        reuslt.code = 200;
        return reuslt;
    }

    public static <T> Result<T> error(String msg) {
        Result result = new Result();
        result.msg = msg;
        result.code = 0;
        return result;
    }
}
