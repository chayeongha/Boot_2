package com.cyh.b1.member;//매퍼파일의 위치를 나타냄

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper {

	//회원가입
	public int memberJoin(MemberVO memberVO)throws Exception;
	
	//로그인
	public MemberVO memberLogin(MemberVO memberVO)throws Exception;
	
	//아이디 중복체크
	public MemberVO memberIdCheck(MemberVO memberVO)throws Exception;
	
}
