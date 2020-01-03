package com.cyh.b1.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MemberInterceptor extends HandlerInterceptorAdapter{

	
	//마이페이지 들어가기전 프리핸들 로그아웃이된상태로못들어가도록
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//세션에서 멤버객체를 가져온다.	
		Object obj = request.getSession().getAttribute("member");
		if(obj != null) {
			
			return true;//트루면 게속 진행.
		}else {
			
			response.sendRedirect("./memberLogin");//현재같은위치기때문에./
			return false;//펄스면 진입불가임으로 다른곳으로 보내준다.
			
		}
		
		
	}
	
	
	
	
}
