package com.portfolio.yoonho.model;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/*
 * @Data
 *  - @Getter, @Setter 등의 설정을 통합적으로 설정하는 어노테이션
 * 
 */
@Data
@Alias("userInfo")
public class UserInfoVO {
	@ApiParam(value="사용자ID", required = true)
	@JsonProperty
	private String userId;
	
	@ApiParam(value="사용자 비밀번호", required = true)
	@JsonProperty
	private String userPw;
	
	@ApiParam(value="사용자 이름")
	@JsonProperty
	private String userName;
	
	@ApiParam(value="사용자 이메일")
	@JsonProperty
	private String userEmail;
	
	@ApiParam(value="사용자 연락처")
	@JsonProperty
	private String userPhone;
}

