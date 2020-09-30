package com.github.weny.springcloud.springcloudcommon.message;

import lombok.Data;

import java.io.Serializable;

@Data
public class MsgBean implements Serializable {
    private String msg;
    private int type;
    private Integer userId;   //接受
    private Integer talkerId; //发送
}
