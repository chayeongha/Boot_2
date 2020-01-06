package com.cyh.b1.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CustomSchedule {
	
		//메서드가 언제실행할지 설정 
		//@Scheduled(fixedRate = 1000)
		@Scheduled(fixedRateString =  "1000")
		public void fixRateSchedule( )throws Exception {
			//System.out.println("FixRate : " + Thread.currentThread().getName());
			Thread.sleep(2000);
		}
		
		//@Scheduled(fixedDelay = 1000)
		@Scheduled(fixedDelayString = "1000", initialDelay = 1000)
		
		public void fixedDelaySchedule()throws Exception{
			//System.out.println("fixDelay : " + Thread.currentThread().getName());
			Thread.sleep(2000);
		}
		
		@Scheduled(cron = "*/3 * * * * *")
		public void cronSchedule()throws Exception {
			//System.out.println("쉬는시간지켜유 .."+Thread.currentThread().getName());
		}
		
		
}
