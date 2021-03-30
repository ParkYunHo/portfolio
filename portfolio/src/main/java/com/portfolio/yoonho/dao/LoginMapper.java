package com.portfolio.yoonho.dao;

import com.portfolio.yoonho.model.UserInfoVO;

public interface LoginMapper {
	public String loginProcess(UserInfoVO userInfo) throws Exception;
}
