package com.portfolio.yoonho.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/*
 * @Entity : Entity 클래스임을 명시. 해당 클래스에 매핑되므로 필수적으로 선언
 * @Table : 매핑할 테이블명을 지정
 * @Data : Lombok
 * @Id : 기본키임을 나태냄. 모든 Entity클래스에는 @Id 설정이 필요. 기본키가 "복합키"로 설정된 경우 @Embeddedid 사용
 * @Column : 기본적으로 선언된 변수명으로 테이블과 매핑하나 컬럼명이 다를 경우 별도 선언필요
 * 
 */

@Entity
@Data
@Table(name="EC_SM_USER_MASTER@TEST")
public class UserInfoEntity {
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="EMAIL_ADDR")
	private String userEmail;
	
//	@Column(name="DEPT_CODE")
//	private String deptCode;
//	
//	@Column(name="JOB_GRADE_CODE")
//	private String jobGradeCode;
}
