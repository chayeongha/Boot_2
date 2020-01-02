package com.cyh.b1.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cyh.b1.robot.LeftArm;
import com.cyh.b1.robot.RightArm;


@Configuration
public class RobotConfig {

	@Bean("left")
	public LeftArm getLeftArm()throws Exception{
		LeftArm leftArm= new LeftArm();
		
		
		return leftArm;
		
	}
	
	public RightArm getRightArm()throws Exception{
		RightArm rightArm = new RightArm();
		
		return rightArm;
		
	}
}
