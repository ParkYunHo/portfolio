package com.portfolio.yoonho.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.yoonho.controller.page.Login;
import com.portfolio.yoonho.dao.LoginMapper;
import com.portfolio.yoonho.dao.UserMgmtMapper;
import com.portfolio.yoonho.model.UserInfoVO;

@Service
public class LoginService {
	
	private static final Logger log = LoggerFactory.getLogger(Login.class);
	
	@Autowired
	LoginMapper loginMapper;
	
	@Autowired
	UserMgmtMapper userMgmtMapper;
	
	public boolean loginProcess(UserInfoVO userInfo) throws Exception {
		String result = "";
		try {
			result = loginMapper.loginProcess(userInfo);
		}catch(Exception e) {
			log.info(">>> [loginProcess] error : " + e.getMessage());
		}
		
		return result.equals("1") ? true : false;
	}
}
