package com.cyh.b1.robot;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@SpringBootTest
class ArmTest {

	@Resource(name = "left")
	private arm arm1;
	
	
	
	@Test
	void test() {
		assertNotNull(arm1);
		
	}
	
	
	
}
