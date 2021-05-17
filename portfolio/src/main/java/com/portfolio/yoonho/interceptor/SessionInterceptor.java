package com.portfolio.yoonho.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * HandlerInterceptorAdapter Class는 더이상 사용되지 않는다.
 * HandlerInterceptor Interface를 Implements해서 사용해야 한다.
 */

public class SessionInterceptor implements HandlerInterceptor {

	private static final Logger log = LoggerFactory.getLogger(SessionInterceptor.class);

	/* 컨트롤러가 실행되기 전 수행되는 함수 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		
//		try {
//	        if (request.getSession().getAttribute("loginInfo") == null) {
//				response.sendRedirect("/loginMain");
//				return false;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		return true;
	}

	/* 컨트롤러가 실행된 후 수행되는 함수 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
}
