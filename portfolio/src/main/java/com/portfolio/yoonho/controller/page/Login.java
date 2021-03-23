package com.portfolio.yoonho.controller.page;

import java.lang.ProcessBuilder.Redirect;

import javax.tools.DocumentationTool.Location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.portfolio.yoonho.model.UserInfoVO;

@Controller
@RequestMapping(value = "/login")
public class Login {
	
	private static final Logger log = LoggerFactory.getLogger(Login.class);
	private static final String loginPath = "login/";
	
	@RequestMapping(method = RequestMethod.GET)
	public String login() throws Exception{
		return loginPath + "login";
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String loginProcess(UserInfoVO userInfo) throws Exception{
		
		log.info("ID : " + userInfo.getUserId() + ", PW : " + userInfo.getUserPw());
		
		
		
		return "redirect:../";
	}
}
