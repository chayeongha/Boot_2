package com.cyh.b1.member;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void memberJoinTest() throws Exception{
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId("iu3");
		memberVO.setPw("iu3");
		memberVO.setEmail("iu3@iu");
		memberVO.setName("iu3");
		int result=memberMapper.memberJoin(memberVO);
		assertEquals(1, result);
		
	}
	
	

}
