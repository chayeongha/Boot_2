package com.cyh.b1.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface NoticeFilesMapper {

	//public int noticeFilesWrite(NoticeFilesVO noticeFilesVO)throws Exception;
	public int noticeFilesWrite(List<NoticeFilesVO> noticeFilesVOs)throws Exception;
}
