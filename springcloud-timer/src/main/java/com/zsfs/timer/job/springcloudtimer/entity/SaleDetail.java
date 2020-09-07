package com.zsfs.timer.job.springcloudtimer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class SaleDetail implements Serializable {
    private String ChangeBill;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ChangeTime;
    private String ChangeName;
    private Long DetailId;
    private Long ItemId;
    private Long GoodsId;
    private String ItemCode;
    private Long GoodsId1;
    private String GoodsCode;
    private String GoodsName;
}
