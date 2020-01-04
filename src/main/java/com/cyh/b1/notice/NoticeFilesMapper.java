package com.cyh.b1.notice;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.cyh.b1.member.MemberFilesVO;

@Repository
@Mapper
public interface NoticeFilesMapper {
	
	public int noticeFilesInsert(NoticeFilesVO noticeFilesVO)throws Exception;

	public NoticeFilesVO noticeFilesSelect(NoticeFilesVO noticeFilesVO)throws Exception;

}
