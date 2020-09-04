package com.zsfs.timer.job.springcloudtimer.server;

import org.springframework.scheduling.annotation.Scheduled;

public class TimerServer {
    /*每天凌晨1点执行一次："0 0 1 * * ?"*/
    @Scheduled(cron="0 0 1 * * ?")
    public void exportFunc(){
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
