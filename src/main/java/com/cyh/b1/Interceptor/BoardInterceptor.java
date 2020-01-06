package com.cyh.b1.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cyh.b1.member.MemberVO;

@Component
public class BoardInterceptor extends HandlerInterceptorAdapter {

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean pass = false;
		
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		
		if (memberVO.getId().equals("admin")) {
			pass = true;
			return pass;
		}else {
			response.sendRedirect("/");
			return pass;
		}
	}
	
}
