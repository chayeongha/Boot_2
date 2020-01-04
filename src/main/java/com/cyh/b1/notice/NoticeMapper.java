package com.cyh.b1.notice;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface NoticeMapper {
	
	//공지글쓰기
	public int noticeWrite(NoticeVO noticeVO)throws Exception;

}
