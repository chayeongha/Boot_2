package com.cyh.b1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

//@Configuration// xml파일을 자바설정파일로바꿈
public class ScheduleConfig implements SchedulingConfigurer {

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		
		ThreadPoolTaskScheduler  taskScheduler = new ThreadPoolTaskScheduler();
		
		taskScheduler.setPoolSize(8);
		
		taskScheduler.setThreadNamePrefix("Mythread-");
		
		taskScheduler.initialize();
		
		taskRegistrar.setTaskScheduler(taskScheduler);
		
		
		
	}
	
}
