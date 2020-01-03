package com.cyh.b1.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.function.support.HandlerFunctionAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class Customlnterceptor extends HandlerInterceptorAdapter {

	//컨트롤러 진입전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		System.out.println("컨트롤러 진입전");
		return true;
	
	}
	//컨트롤러 종료후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("컨트롤러 종료후");
		
		
	}
	
	
	//jsp완성후
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("jsp 완성후");
	}
	
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//비동기방식으로 요청시 postHandle,afterCompletion 수행하지않고 이메서드를 수행.
		
	}
	
}
