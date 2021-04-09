package com.portfolio.yoonho.controller.page;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.tools.DocumentationTool.Location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.portfolio.yoonho.common.Info;
import com.portfolio.yoonho.model.UserInfoVO;
import com.portfolio.yoonho.service.LoginService;

@Controller
@RequestMapping("/login")
public class Login {
	
	private static final Logger log = LoggerFactory.getLogger(Login.class);
	private static final String loginPath = "login/";
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginMain() throws Exception{
		return loginPath + "loginMain";
	}
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String login() throws Exception{
		return loginPath + "login";
	}
	
	@RequestMapping(value = "/registerPage", method = RequestMethod.GET)
	public String register() throws Exception{
		return loginPath + "register";
	}
	
	@RequestMapping(value = "/forgotPWPage", method = RequestMethod.GET)
	public String forgotPW() throws Exception{
		return loginPath + "forgotPW";
	}
	
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public @ResponseBody String loginProcess(HttpServletResponse res, HttpServletRequest req, UserInfoVO userInfo) throws Exception{

		String result = "";
		if(loginService.loginProcess(userInfo)) {
			
			// 로그인 성공시 Client정보 저장
			loginService.setClientInfo(req, userInfo);
			
			result = Info.RESPONE_RESULT_SUCCESS;
		}else {
			result = Info.RESPONE_RESULT_FAIL;
		}
		
		return result;
	}
}
