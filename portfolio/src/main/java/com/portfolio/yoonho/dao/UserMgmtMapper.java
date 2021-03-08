package com.portfolio.yoonho.dao;

import java.util.List;
import com.portfolio.yoonho.model.UserInfoVO;

public interface UserMgmtMapper {
	public UserInfoVO getUserInfo(String userId) throws Exception;
	public List<UserInfoVO> getUserInfoAll() throws Exception;
	public void registerUserInfo(UserInfoVO userInfo) throws Exception;
	public void updateUserInfo(String userId, UserInfoVO userInfo) throws Exception;
	public void deleteUserInfo(String userId) throws Exception;
}
