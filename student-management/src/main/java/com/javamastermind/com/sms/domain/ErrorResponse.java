package com.javamastermind.com.sms.domain;

public class ErrorResponse {

	private String errorDiscription;
	private String errorCode;

	public String getErrorDiscription() {
		return errorDiscription;
	}

	public void setErrorDiscription(String errorDiscription) {
		this.errorDiscription = errorDiscription;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "ErrorResponse [errorDiscription=" + errorDiscription + ", errorCode=" + errorCode + "]";
	}

}
