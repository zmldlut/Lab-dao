package com.zml.model;

import java.util.Map;

public class Data {
	private int code;
    private String message;
    private Map<String, ?> result;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, ?> getResult() {
		return result;
	}
	public void setResult(Map<String, ?> result) {
		this.result = result;
	}
}
