package com.cyh.b1.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberFilesMapper {

	public int memberFilesInsert(MemberFilesVO memberFilesVO)throws Exception;
	
}
