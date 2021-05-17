package com.portfolio.yoonho.controller.api.userMgmt.jpa;

import java.sql.CallableStatement;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedNativeQuery;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

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
	@PersistenceContext
	EntityManager em;
	
	@ApiOperation(value = "getUserInfo", notes = "특정 사용자 조회")
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public @ResponseBody UserInfoEntity getUserInfo(@ApiParam(value="사용자ID", required = true, example = "user1") @PathVariable(value="id") String id) throws Exception{
		UserInfoEntity ue = null;
		try {
			ue = userRepo.findById(id).get();
			
			// 불필요한 정보 제외처리
			ue.setUserPw("");
		}catch(Exception e) {
			log.error(e.getMessage());
		}
		
		return ue;
	}
	
	@ApiOperation(value = "registerUserInfo", notes = "사용자 등록")
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void registerUserInfo(@ApiParam(value="등록할 사용자 정보", required = true) UserInfoEntity userInfo) throws Exception{
		try {
			if(userRepo.existsById(userInfo.getUserId()) || userInfo.getUserId().equals("") || userInfo.getUserId() == null) {
				log.error("사용자 등록을 위한 ID정보 에러");
			}else {
				String res = em.createNativeQuery("SELECT ENCRYPT(:param) FROM DUAL")
						.setParameter("param", userInfo.getUserPw())
						.getSingleResult().toString();
						
				userInfo.setUserPw(res.toString());
				
				userRepo.save(userInfo);	
			}
		}catch(Exception e) {
			log.error(e.getMessage());
		}
	}
	
	@ApiOperation(value = "updateUserInfo", notes = "사용자 정보 변경")
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody void updateUserInfo(@ApiParam(value="변경할 사용자 정보", required = true) UserInfoEntity userInfo) throws Exception{
		try {
			if(userInfo.getUserId().equals("") || userInfo.getUserId() == null) {
				log.error("사용자 정보를 업데이트를 위한 ID정보 누락");
			}else {
				userRepo.save(userInfo);	
			}
		}catch(Exception e) {
			log.error(e.getMessage());
		}
	}
}
