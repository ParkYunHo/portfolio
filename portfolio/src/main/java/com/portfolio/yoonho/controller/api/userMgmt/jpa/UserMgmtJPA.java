package com.portfolio.yoonho.controller.api.userMgmt.jpa;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.yoonho.model.UserInfoVO;
import com.portfolio.yoonho.repository.UserInfoEntity;
import com.portfolio.yoonho.repository.UserInfoEntityRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/jpa/userMgmt")
public class UserMgmtJPA {
	private static final Logger log = LoggerFactory.getLogger(UserMgmtJPA.class);
	
	@Autowired
	UserInfoEntityRepository userRepo;
	
	@ApiOperation(value = "getUserInfo", notes = "특정 사용자 조회")
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public @ResponseBody UserInfoEntity getUserInfo(@ApiParam(value="사용자ID", required = true, example = "user1") @PathVariable(value="id") String id) throws Exception{
		UserInfoEntity ue = null;
		try {
			ue = userRepo.findById(id).get();
		}catch(Exception e) {
			log.error(e.getMessage());
		}
		
		return ue;
	}
	
	@ApiOperation(value = "registerUserInfo", notes = "사용자 등록")
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void registerUserInfo(@ApiParam(value="등록할 사용자 정보", required = true) UserInfoEntity userInfo) throws Exception{
		try {
			log.info("<JPA UserInfo>");
			log.info(userInfo.getUserId());
			log.info(userInfo.getUserName());
			log.info(userInfo.getUserEmail());
//			log.info(userInfo.getDeptCode());
//			log.info(userInfo.getJobGradeCode());
			userRepo.save(userInfo);
		}catch(Exception e) {
			log.error(e.getMessage());
		}
	}
}
