package com.portfolio.yoonho.service;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.portfolio.yoonho.common.Info;
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
	@Autowired
	RedisTemplate<String, Object> rt;
	
	private HashOperations<String, String, Object> hop = null;
	private String userId = "";
	
	public boolean loginProcess(UserInfoVO userInfo) throws Exception {
		String result = "";
		try {
			result = loginMapper.loginProcess(userInfo);
		}catch(Exception e) {
			log.info(">>> [loginProcess] error : " + e.getMessage());
		}
		
		return result.equals("1") ? true : false;
	}
	
	public void setClientInfo(HttpServletRequest req, UserInfoVO userInfo) {
		
		userId = userInfo.getUserId();
		
		// Session 정보 저장
		req.getSession().setAttribute("loginInfo", userInfo);
		req.getSession().setMaxInactiveInterval(Info.SESSION_INTERVAL);
		
		
		// Client FingerPrint Redis에 저장
		hop = rt.opsForHash();
		hop.put(userId, "IP", req.getRemoteAddr() == null ? "" : req.getRemoteAddr().toString());
		hop.put(userId, "HOST", req.getRemoteHost() == null ? "" : req.getRemoteHost().toString());
		hop.put(userId, "PORT", req.getRemotePort() == 0 ? "" : req.getRemotePort()+"");
		hop.put(userId, "USER", req.getRemoteUser() == null ? "" : req.getRemoteUser().toString());
	 
		getUserAgentInfo(req.getHeader("User-Agent"));
		
		// TTL 설정
		rt.expire(userId, Info.FINGERPRINT_TTL, TimeUnit.SECONDS);
		
		
		log.info("=====================================");
		log.info(" >>> [ClientInfo] USERID : " + userId);
		log.info(" >>> [ClientInfo] TTL : " + Info.FINGERPRINT_TTL + "s");
		log.info(" >>> [ClientInfo] USERID : " + userId);
		log.info(" >>> [ClientInfo] IP : " + hop.get(userId, "IP").toString());
		log.info(" >>> [ClientInfo] HOST : " + hop.get(userId, "HOST").toString());
		log.info(" >>> [ClientInfo] PORT : " + hop.get(userId, "PORT").toString());
		log.info(" >>> [ClientInfo] USER : " + hop.get(userId, "USER").toString());
		log.info(" >>> [ClientInfo] BROWSER : " + hop.get(userId, "BROWSER").toString());
		log.info(" >>> [ClientInfo] MOBILEOS : " + hop.get(userId, "MOBILEOS").toString());
		log.info(" >>> [ClientInfo] OS : " + hop.get(userId, "OS").toString());
		log.info("=====================================");
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
		hop.put(userId, "BROWSER", browser);
		
		
		// MobileOS 체크
		String mobileOS = "";
		if(userAgent.indexOf("Android") != -1) {
			mobileOS = "Android";
		}
		else if(userAgent.indexOf("iPhone") != -1) {
			mobileOS = "iPhone";
		}
		hop.put(userId, "MOBILEOS", mobileOS);
		
		
		// OS 체크
		String os = "";
		if(userAgent.indexOf("NT 6.0") != -1) os = "Windows Vista/Server 2008";
		else if(userAgent.indexOf("NT 5.2") != -1) os = "Windows Server 2003";
		else if(userAgent.indexOf("NT 5.1") != -1) os = "Windows XP";
		else if(userAgent.indexOf("NT 5.0") != -1) os = "Windows 2000";
		else if(userAgent.indexOf("NT 10.0") != -1) os = "Windows 10";
		else if(userAgent.indexOf("NT") != -1) os = "Windows NT";
		else if(userAgent.indexOf("9x 4.90") != -1) os = "Windows Me";
		else if(userAgent.indexOf("98") != -1) os = "Windows 98";
		else if(userAgent.indexOf("95") != -1) os = "Windows 95";
		else if(userAgent.indexOf("Win16") != -1) os = "Windows 3.x";
		else if(userAgent.indexOf("Windows") != -1) os = "Windows";
		else if(userAgent.indexOf("Linux") != -1) os = "Linux";
		else if(userAgent.indexOf("Macintosh") != -1) os = "Macintosh";
		else os = ""; 
		hop.put(userId, "OS", os);
	}
}
