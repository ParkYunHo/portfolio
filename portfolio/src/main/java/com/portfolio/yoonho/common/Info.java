package com.portfolio.yoonho.common;

public class Info {
	// Result
	public static final String RESPONE_RESULT_SUCCESS = "SUCCESS";
	public static final String RESPONE_RESULT_FAIL = "FAIL";
	
	//	Login Session 유지 시간 - 단위 초
	public static final int SESSION_INTERVAL = 600;
	
	// Redis에 저장된 FingerPrint정보 TTL (생존주기)
	public static final int FINGERPRINT_TTL = 3600;
}
