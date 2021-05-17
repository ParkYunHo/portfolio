package com.portfolio.yoonho.controller.page;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolio.yoonho.model.UserInfoVO;

@Controller
public class Main {
	
	private static final Logger log = LoggerFactory.getLogger(Main.class);
	
	@RequestMapping("/")
	public String main(HttpServletRequest request) throws Exception {
		UserInfoVO userInfo = (UserInfoVO)request.getSession().getAttribute("loginInfo");
		if(userInfo != null) {
			log.info(" >>>> [MAIN] LOGIN : " + userInfo.getUserId().toString());
		}else {
			log.info(" >>>> [MAIN] NO SESSION");	
		}
		
		return "/main";
	}
	
	@RequestMapping("/navbar")
	public String navbar() throws Exception {
		return "/contents/navbar";
	}
	
	@RequestMapping("/sidebar")
	public String sidebar() throws Exception {
		return "/contents/sidebar";
	}
	
	@RequestMapping("/footer")
	public String footer() throws Exception {
		return "/contents/footer";
	}
	
	@RequestMapping("/content")
	public String content() throws Exception {
		return "/contents/content";
	}	
	
	@RequestMapping("/apiDocs")
	public String apiDocs() throws Exception {
		return "redirect:/swagger-ui.html";
	}
}
