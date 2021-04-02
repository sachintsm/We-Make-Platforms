package com.javamastermind.com.sms.domain;

import java.util.Set;

public class SuccessResponse {
	private String Message;
	private String SuccessCode;
	private Set<Object> ResponseObject;

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getSuccessCode() {
		return SuccessCode;
	}

	public void setSuccessCode(String successCode) {
		SuccessCode = successCode;
	}

	public Set<Object> getResponseObject() {
		return ResponseObject;
	}

	public void setResponseObject(Set<Object> responseObject) {
		ResponseObject = responseObject;
	}

	@Override
	public String toString() {
		return "SucessResponse [Message=" + Message + ", SuccessCode=" + SuccessCode + ", ResponseObject="
				+ ResponseObject + "]";
	}

}
