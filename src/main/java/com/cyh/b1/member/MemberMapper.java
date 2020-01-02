package com.cyh.b1.member;//매퍼파일의 위치를 나타냄

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper {

	public int memberJoin(MemberVO memberVO)throws Exception;
	
	
}
