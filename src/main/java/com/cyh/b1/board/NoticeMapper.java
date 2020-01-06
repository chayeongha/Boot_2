package com.cyh.b1.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.cyh.b1.util.Pager;

@Repository
@Mapper
public interface NoticeMapper {
	
	//공지글쓰기
	public int boardCount(Pager pager)throws Exception;
	
	public List<NoticeVO> boardList(Pager pager)throws Exception;
	
	public int boardWrite(NoticeVO noticeVO) throws Exception;
	
	public NoticeVO boardSelect(NoticeVO noticeVO)throws Exception;
}
