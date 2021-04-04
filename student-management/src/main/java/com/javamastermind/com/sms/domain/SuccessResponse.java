package com.javamastermind.com.sms.domain;

import java.util.Set;

public class SuccessResponse {
	private String message;
	private String responseCode;
	private Set<Object> responseObject;

	public String getMessage() {
		return message;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public Set<Object> getResponseObject() {
		return responseObject;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public void setResponseObject(Set<Object> responseObject) {
		this.responseObject = responseObject;
	}
}
