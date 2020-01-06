package com.cyh.b1.board;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cyh.b1.util.Pager;
import com.fasterxml.jackson.annotation.JacksonInject.Value;


@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Resource(name = "noticeService")
	private NoticeService noticeService;


	@ModelAttribute(name = "noticeVO")
	public NoticeVO getNoticeVO() {
		return new NoticeVO();
	}


	@GetMapping("noticeList")
	public ModelAndView noticeList(Pager pager)throws Exception{
		System.out.println(pager.getCurPage());
		ModelAndView mv = new ModelAndView();

		List<NoticeVO> ar = noticeService.boardList(pager);

		mv.addObject("pager", pager);
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");


		return mv;
	}

	//공지글쓰기
	@GetMapping("noticeWrite")
	public String noticeWrite()throws Exception{
		return "board/boardWrite";
	}

	
	@PostMapping("noticeWrite")
	public ModelAndView noticeWrite(@Valid NoticeVO noticeVO, BindingResult bindingResult, MultipartFile [] files)throws Exception{
		System.out.println("test controller");
		ModelAndView mv = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mv.setViewName("board/boardWrite");
		}else {
			int result = noticeService.boardWrite(noticeVO, files);
			String msg="Write Fail";
			if(result>0) {
				msg="Write Success";
			}
			mv.addObject("msg", msg);
			mv.addObject("path", "./noticeList");
		}

		return mv;
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView noticeSelect(NoticeVO noticeVO)throws Exception {
		
		ModelAndView mv= new ModelAndView();
		noticeVO = noticeService.boardSelect(noticeVO);
		
		mv.addObject("notice", noticeVO);
		mv.setViewName("/board/boardSelect");
		
		return mv;
		
	}
	
}
