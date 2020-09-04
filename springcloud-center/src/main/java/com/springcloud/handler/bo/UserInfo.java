package com.springcloud.handler.bo;

import lombok.Data;

@Data
public class UserInfo {
    private Integer userId;
    private String userName;
    private String userAccount;
    private String userPassword;
    private String channelId;
    private Integer userGroupId;
    private Integer userStatus;
}