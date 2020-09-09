package com.weny.githubsty.springcloud.result;

import lombok.Data;

@Data
public class CommonResult<T> {
    private T data;
    private int code;
    private String message;

    public CommonResult(T data, int code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }
}
