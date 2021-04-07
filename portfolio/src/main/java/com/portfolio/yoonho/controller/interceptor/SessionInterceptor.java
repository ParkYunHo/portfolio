package com.portfolio.yoonho.controller.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		log.info("==========================================================");
		log.info(">>>> [Client Session Info] Time		: " + f.format(new Date()));
		log.info(">>>> [Client Session Info] Param ");
		Map<String, String[]> param = request.getParameterMap(); 
		for(String key : param.keySet()) {
			for(String value : param.get(key)) {
				log.info(">>>> [Client Session Info]  > " + key + ": " + value);	
			}
		}
		log.info(">>>> [Client Session Info] URL		: " + request.getRequestURI());
		log.info(">>>> [Client Session Info] IP		: " + request.getRemoteAddr());
		log.info(">>>> [Client Session Info] Host		: " + request.getRemoteHost());
		log.info(">>>> [Client Session Info] Port		: " + request.getRemotePort());
		log.info(">>>> [Client Session Info] User		: " + request.getRemoteUser());
		
		getUserAgentInfo(request.getHeader("User-Agent"));
		
		log.info("==========================================================");
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	/* 컨트롤러가 실행된 후 수행되는 함수 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	/* UserAgent 분석 함수 */
	private void getUserAgentInfo(String userAgent) {
		// 브라우저 체크
		String browser = "";
		if(userAgent.indexOf("Trident") > -1 || userAgent.indexOf("MSIE") > -1) { //IE

			if(userAgent.indexOf("Trident/7") > -1) 
				browser = "IE 11";
			else if(userAgent.indexOf("Trident/6") > -1) 
				browser = "IE 10";
			else if(userAgent.indexOf("Trident/5") > -1)
				browser = "IE 9";
			else if(userAgent.indexOf("Trident/4") > -1)
				browser = "IE 8";
			else if(userAgent.indexOf("edge") > -1)
				browser = "IE edge";

		}else if(userAgent.indexOf("Whale") > -1){ //네이버 WHALE
			browser = "WHALE " + userAgent.split("Whale/")[1].toString().split(" ")[0].toString();
		}else if(userAgent.indexOf("Opera") > -1 || userAgent.indexOf("OPR") > -1){ //오페라
			if(userAgent.indexOf("Opera") > -1) 
				browser = "OPERA " + userAgent.split("Opera/")[1].toString().split(" ")[0].toString();
			else if(userAgent.indexOf("OPR") > -1) 
				browser = "OPERA " + userAgent.split("OPR/")[1].toString().split(" ")[0].toString();
		}else if(userAgent.indexOf("Firefox") > -1){ //파이어폭스
			browser = "FIREFOX " + userAgent.split("Firefox/")[1].toString().split(" ")[0].toString();
		}else if(userAgent.indexOf("Safari") > -1 && userAgent.indexOf("Chrome") == -1 ){ //사파리
			browser = "SAFARI " + userAgent.split("Safari/")[1].toString().split(" ")[0].toString();
		}else if(userAgent.indexOf("Chrome") > -1){ //크롬
			browser = "CHROME " + userAgent.split("Chrome/")[1].toString().split(" ")[0].toString();
		}
		
		log.info(">>>> [Client Session Info] Browser		: " + browser);
		
		
		// Mobile&Desktop 체크
		boolean isMobile = false;
		String mobileOS = "";
		if(userAgent.indexOf("Android") != -1) {
			isMobile = true;
			mobileOS = "Android";
		}
		else if(userAgent.indexOf("iPhone") != -1) {
			isMobile = true;
			mobileOS = "iPhone";
		}
		
		if(isMobile) {
			log.info(">>>> [Client Session Info] MobileOS	: " + mobileOS);
		}else {
			// OS 체크
			String os = "";
			if(userAgent.indexOf("NT 6.0") != -1) os = "Windows Vista/Server 2008";
			else if(userAgent.indexOf("NT 5.2") != -1) os = "Windows Server 2003";
			else if(userAgent.indexOf("NT 5.1") != -1) os = "Windows XP";
			else if(userAgent.indexOf("NT 5.0") != -1) os = "Windows 2000";
			else if(userAgent.indexOf("NT") != -1) os = "Windows NT";
			else if(userAgent.indexOf("9x 4.90") != -1) os = "Windows Me";
			else if(userAgent.indexOf("98") != -1) os = "Windows 98";
			else if(userAgent.indexOf("95") != -1) os = "Windows 95";
			else if(userAgent.indexOf("Win16") != -1) os = "Windows 3.x";
			else if(userAgent.indexOf("Windows") != -1) os = "Windows";
			else if(userAgent.indexOf("Linux") != -1) os = "Linux";
			else if(userAgent.indexOf("Macintosh") != -1) os = "Macintosh";
			else os = ""; 
			
			log.info(">>>> [Client Session Info] OS		: " + os);
		}
	}
}
