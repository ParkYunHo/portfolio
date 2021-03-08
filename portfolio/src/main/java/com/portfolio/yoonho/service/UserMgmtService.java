package com.portfolio.yoonho.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.yoonho.dao.UserMgmtMapper;
import com.portfolio.yoonho.model.UserInfoVO;

@Service
public class UserMgmtService {
	@Autowired
	UserMgmtMapper userMgmtMapper;
	
	public UserInfoVO getUserInfo(String id) throws Exception {
		return userMgmtMapper.getUserInfo(id);
	}
	
	public List<UserInfoVO> getUserInfoAll() throws Exception {
		return userMgmtMapper.getUserInfoAll();
	}
	
	public void registerUserInfo(UserInfoVO userInfo) throws Exception {
		if(!userInfo.getUserId().isEmpty() && !userInfo.getUserPw().isEmpty()) {
			userMgmtMapper.registerUserInfo(userInfo);
		}
	}
	
	public void updateUserInfo(String id, UserInfoVO userInfo) throws Exception {
		userMgmtMapper.updateUserInfo(id, userInfo);
	}
	
	public void deleteUserInfo(String id) throws Exception {
		userMgmtMapper.deleteUserInfo(id);
	}
}