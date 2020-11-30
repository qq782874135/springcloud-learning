package com.springcloud.weny.im.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/im/")
public class ChatController {

    @GetMapping("chatToUser")
    public void chatToUser(){

    }

}

