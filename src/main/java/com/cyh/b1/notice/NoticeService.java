package com.cyh.b1.notice;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cyh.b1.member.MemberFilesMapper;
import com.cyh.b1.member.MemberFilesVO;
import com.cyh.b1.util.FilePathGenerator;
import com.cyh.b1.util.FileSaver;

@Service
public class NoticeService {

		@Autowired
		private NoticeMapper noticeMapper;
		
		@Autowired
		private NoticeFilesMapper noticeFilesMapper;
		
		@Autowired
		private FilePathGenerator filePathGenerator;
		
		@Autowired
		private FileSaver fileSaver;
		
		//파일 셀렉트
				public NoticeFilesVO noticeFilesSelect(NoticeFilesVO noticeFilesVO)throws Exception {
					
					return noticeFilesMapper.noticeFilesSelect(noticeFilesVO);
				}
		
		// 공지글쓰기
		public int noticeWrite(NoticeVO noticeVO, MultipartFile files)throws Exception {
			
			File file =filePathGenerator.getUseClassPathResource("upload");
			String fileName=fileSaver.save(file, files);
			
			System.out.println(fileName);
			int result = noticeMapper.noticeWrite(noticeVO);
			
			NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
			noticeFilesVO.setNum(noticeVO.getNum());
			noticeFilesVO.setFname(fileName);
			noticeFilesVO.setOname(files.getOriginalFilename());
			
			result= noticeFilesMapper.noticeFilesInsert(noticeFilesVO);
			
			return result;
		}
	
		
}
