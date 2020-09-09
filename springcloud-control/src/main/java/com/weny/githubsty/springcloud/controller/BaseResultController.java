package com.weny.githubsty.springcloud.controller;

import com.weny.githubsty.springcloud.result.CommonResult;
import com.weny.githubsty.springcloud.result.ResultEnum;

public class BaseResultController {

    public static class Result {

        public static <T>CommonResult success(T data) {
            return new CommonResult(data, ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMessage());
        }
        public static <T>CommonResult success() {
            return new CommonResult(null, ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMessage());
        }

        public static <T>CommonResult error(String message){
            return new CommonResult( null,ResultEnum.ERROR.getCode(),message);
        }
        public static <T>CommonResult error(){
            return new CommonResult( null,ResultEnum.ERROR.getCode(),ResultEnum.ERROR.getMessage());
        }


    }
}
