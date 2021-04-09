package com.portfolio.yoonho.common;

import java.util.List;
import java.util.Map;

public class ResultObject {
	private String result;
	private String message;
	private List<Map<String, Object>> datas;
	
	// 생성자
	public ResultObject() {}
	public ResultObject(String result) {
		// TODO Auto-generated constructor stub
		setResult(result);
	}
	public ResultObject(String result, String msg) {
		// TODO Auto-generated constructor stub
		this.result = result;
		this.message = msg;
	}
	public ResultObject(String result, String msg, List<Map<String, Object>> datas) {
		// TODO Auto-generated constructor stub
		this.result = result;
		this.message = msg;
		this.datas = datas;
	}
	public ResultObject(String result, List<Map<String, Object>> datas) {
		// TODO Auto-generated constructor stub
		this.result = result;
		this.datas = datas;
	}
	
	// Getter/Setter
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getMessage() {
		return message;
	}
	public ResultObject setMessage(String message) {
		this.message = message;
		return this;
	}

	public List<Map<String, Object>> getDatas() {
		return datas;
	}

	public ResultObject setDatas(List<Map<String, Object>> datas) {
		this.datas = datas;
		return this;
	}
}
