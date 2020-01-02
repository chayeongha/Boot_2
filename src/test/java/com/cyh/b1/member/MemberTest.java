package com.cyh.b1.member;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional//테스트만 하고 데이터에 실제 안들어가고싶을떄 트랜잭셔널을 사용.
@Rollback
class MemberTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void memberJoinTest() throws Exception{
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId("iu34");
		memberVO.setPw("iu34");
		memberVO.setEmail("iu34@iu");
		memberVO.setName("iu34");
		int result=memberMapper.memberJoin(memberVO);
		assertEquals(1, result);
		
	}//실제로 테스트는 성공하고 실제로 데이터 안들어감.
	
	

}
