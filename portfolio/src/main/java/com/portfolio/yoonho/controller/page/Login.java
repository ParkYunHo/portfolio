package com.portfolio.yoonho.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login {
	
	private static final String loginPath = "login/";
	
	@RequestMapping("/login")
	public String login() throws Exception{
		return loginPath + "login";
	}
}
