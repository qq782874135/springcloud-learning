package com.springcloud.handler.bo;

import lombok.Data;

import java.io.Serializable;
@Data
public class MsgBean implements Serializable {
    private String msg;
    private int type;
    private Integer userId;
}
