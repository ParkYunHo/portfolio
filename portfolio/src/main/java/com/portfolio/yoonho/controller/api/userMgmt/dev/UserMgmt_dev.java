package com.portfolio.yoonho.controller.api.userMgmt.dev;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.yoonho.model.UserInfoVO;
import com.portfolio.yoonho.service.UserMgmtService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/dev/userMgmt")
public class UserMgmt_dev {
	
	/*
	 *  < HTTP Method >
	 *  GET : SELECT (조회)
	 *  POST : INSERT (삽입)
	 *  PUT : UPDATE (변경)
	 *  DELETE : DELETE (삭제)
	 */
	
	@Autowired
	UserMgmtService userMgmtService;
	
	@ApiOperation(value = "getUserInfo", notes = "특정 사용자 조회")
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public @ResponseBody UserInfoVO getUserInfo(@ApiParam(value="사용자ID", required = true, example = "user1") @PathVariable(value="id") String id) throws Exception{
		return userMgmtService.getUserInfo(id);
	}
	
	@ApiOperation(value = "getUserInfoAll", notes = "전체 사용자 조회(개발자용)")
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<UserInfoVO> getUserInfoAll() throws Exception{
		return userMgmtService.getUserInfoAll();
	}
	
	@ApiOperation(value = "registerUserInfo", notes = "사용자 등록")
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void registerUserInfo(@ApiParam(value="등록할 사용자 정보", required = true) UserInfoVO userInfo) throws Exception{
		userMgmtService.registerUserInfo(userInfo);
	}
	
	@ApiOperation(value = "updateUserInfo", notes = "사용자 정보 변경")
	@RequestMapping(method = RequestMethod.PUT, value="/{id}")
	public @ResponseBody void updateUserInfo(
			@ApiParam(value="변경할 사용자ID", required = true) @PathVariable(value="id") String id, 
			@ApiParam(value="변경할 사용자 정보", required = true) UserInfoVO userInfo) throws Exception{
		userMgmtService.updateUserInfo(id, userInfo);
	}
	
	@ApiOperation(value = "deleteUserInfo", notes = "사용자 정보 삭제")
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public @ResponseBody void deleteUserInfo(@ApiParam(value="삭제할 사용자ID", required = true) @PathVariable(value="id") String id) throws Exception{
		userMgmtService.deleteUserInfo(id);
	}
}
