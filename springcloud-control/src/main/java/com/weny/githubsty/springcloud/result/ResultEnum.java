package com.weny.githubsty.springcloud.result;

public enum ResultEnum {
    SUCCESS(200,"success"),
    ERROR(500,"error"),
    SELF(201,"self"); //自定义

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ResultEnum(int code, String message){
        this.code=code;
        this.message=message;
    }

}
