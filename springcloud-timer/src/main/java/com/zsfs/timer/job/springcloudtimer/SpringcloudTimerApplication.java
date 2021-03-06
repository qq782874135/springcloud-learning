package com.zsfs.timer.job.springcloudtimer;

import com.zsfs.timer.job.springcloudtimer.server.TimerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties
@RestController

public class SpringcloudTimerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudTimerApplication.class, args);
	}

	@Autowired
	TimerServer timerServer;


	@GetMapping("/exp")
	public void test(){
		 timerServer.exportFunc();
	}

	@GetMapping("/force")
	public String forceFuncByDate(String startDate,String endDate){
		return  timerServer.forceFuncByDate(startDate,endDate);
	}
}
