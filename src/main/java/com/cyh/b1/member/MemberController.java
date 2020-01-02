package com.cyh.b1.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {

		@Autowired
		private MemberService memberService;
		
		@RequestMapping(value = "memberJoin", method = RequestMethod.GET)
		public String memberJoin()throws Exception {
		
			return "member/memberJoin";
		}
		
		@PostMapping("memberJoin")										//files인이유 넘어가는 파라미터name과같게..
		public ModelAndView memberJoin(MemberVO memberVO, MultipartFile files)throws Exception {
			
			ModelAndView mv= new ModelAndView();
			int result = memberService.memberJoin(memberVO, files);
			
			String msg="join실패";
			String path="../";//루트밑
			if(result>0) {
				msg="Join Success";
			}
			mv.addObject("path", path);
			mv.addObject("msg", msg);
			mv.setViewName("common/result");
			
			return mv;
			
			
		}
		
		@GetMapping("memberLogin")
		public void memberLogin()throws Exception {
			
			
		}
		
		@PostMapping("memberLogin")
		public ModelAndView memberLogin(MemberVO memberVO , HttpSession session)throws Exception {
			
			memberVO= memberService.memberLogin(memberVO);
			
			ModelAndView mv = new ModelAndView();
			
			String msg = "로그인 실패";
			
			if(memberVO != null){
				session.setAttribute("member", memberVO);
				mv.setViewName("redirect:../");
			}else {
				
				mv.addObject("msg", msg);
				mv.addObject("path", "../");
				mv.setViewName("common/result");
				
			}
			return mv;
			
			
		}
		
}
