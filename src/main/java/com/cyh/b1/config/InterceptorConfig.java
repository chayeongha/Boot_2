package com.cyh.b1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cyh.b1.Interceptor.Customlnterceptor;
import com.cyh.b1.Interceptor.MemberInterceptor;

@Configuration//xml									//add interceptor라는 메서드가 여기안에있음
public class InterceptorConfig implements WebMvcConfigurer{


	@Autowired
	private Customlnterceptor customlnterceptor;
	
	@Autowired
	private MemberInterceptor memberInterceptor;
	
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//Interceptor 등록하기
		registry.addInterceptor(customlnterceptor)
		//INTERCEPTOR를 사용할 URI 패턴 등록
		.addPathPatterns("/member/*")//패턴추가.
		//.addPathPatterns("/member/memberPage");메서드 체인닝 이라고 게속 이어서 패턴을 추가가능.
		//INTERCEPTOR를 제외할 URI 패턴 등록
		.excludePathPatterns("/member/memberLogin")
		.excludePathPatterns("/member/memberJoin");//패턴을 제외.
		
		//WebMvcConfigurer.super.addInterceptors(registry);
		
		//////////////////////////////////////////////////////
		//멤버인터셉터 등록
		registry.addInterceptor(memberInterceptor)
		.addPathPatterns("/member/memberPage");//멤버페이지로 들어왔을떄 패턴등록.
		
		
	}
		
	
}
