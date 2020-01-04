package com.cyh.b1.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cyh.b1.member.MemberVO;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {

		@Autowired
		private NoticeService noticeService;
		
		//공지글쓰기
		@GetMapping("noticeWrite")
		public String noticeWrite()throws Exception {
		
			return "notice/noticeWrite";
		}
		
		@PostMapping("noticeWrite")
		public ModelAndView noticeWrite(NoticeVO noticeVO , MultipartFile files)throws Exception{
			ModelAndView mv = new ModelAndView();
			

			
			int result = noticeService.noticeWrite(noticeVO, files);
			
			String msg= "글쓰기 실패";
			String path="../";//루트밑
			
			if(result == 1) {
				msg="글쓰기 성공";
			}
			mv.addObject("msg",msg);
			mv.addObject("path", path);
			mv.setViewName("common/result");
			
			return mv;
			
		}
		
		
}
