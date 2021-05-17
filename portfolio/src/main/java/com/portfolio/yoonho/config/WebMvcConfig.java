package com.portfolio.yoonho.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.portfolio.yoonho.interceptor.SessionInterceptor;

/*
 *  @EnableWebMvc를 사용하면 ViewResolver값이 자동으로 등록
 *  그러나 다양한 Config를 설정히 똑같은 코드를 반복적으로 써야되는 불편함 존재
 *  
 *  WebMvcConfigurer Class를 상속받아 사용하면 @EnableWebMvc를 자동으로 세팅해주며 개발자가 원하는 설정 가능 
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	/* Interceptor 등록 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new SessionInterceptor());
	}
}
